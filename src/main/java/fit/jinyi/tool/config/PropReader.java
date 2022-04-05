package fit.jinyi.tool.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件读取器
 * @author liujin
 * @since JDK8
 */
public class PropReader {
    private PropReader(){}
    private static class SingletonHolder{
        private static final PropReader instance = new PropReader();
    }
    public static PropReader getInstance(){
        return SingletonHolder.instance;
    }
    private String bootstrapPath = "bootstrap.properties";
    private Class readPropClass;
    private String propPath = bootstrapPath;

    public String getPropPath() {
        return propPath;
    }

    public PropReader setPropPath(String propPath) {
        this.propPath = propPath;
        cache.clear();
        return this;
    }

    public PropReader setReadPropClass(Class readPropClass) {
        this.readPropClass = readPropClass;
        return this;
    }

    /**
     * 读取配置文件，构造Properties对象实例
     * @return
     */
    private Properties getProp() {
        Properties p = new Properties();
        try {

//            InputStream in = ClassLoader.getSystemResourceAsStream(propPath);
            InputStream in;
            if (this.readPropClass == null){
                in = new FileInputStream(this.getClass().getResource("/").getPath()+propPath);
            }else{
                in = new FileInputStream(this.readPropClass.getResource("/").getPath()+propPath);
            }

            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
    private Map<Long,Properties> cache = new HashMap<>();

    /**
     * 定期重新读取配置文件，热加载
     * 默认与上次加载时间相差超过3分钟，重新维护一份新的配置信息
     */
    private void maintainCache(){
        //5min
        Long TIMER = 5*60*1000L;
        Long timestamp = System.currentTimeMillis();
        Properties p = null;
        if (cache.isEmpty()||(timestamp-cache.keySet().stream().findFirst().get())>TIMER){
            p = getProp();
            cache.clear();
            cache.put(timestamp,p);
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public String get(String key){
        maintainCache();
        Properties p = cache.values().stream().findFirst().get();
        if(p.get(key)==null){
            return null;
        }
        return p.get(key).toString();
    }

    public String getOrElse(String key,String def){
        String v = get(key);
        return v==null?def:v;
    }

}
