package fit.jinyi.tool.config;

import fit.jinyi.tool.serialization.SerializationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Yaml配置文件读取器
 * [link]:https://www.baeldung.com/java-snake-yaml
 *        https://bitbucket.org/asomov/snakeyaml/wiki/Documentation
 * @author liujin
 * @date 2020/7/16
 * @since JDK8
 */
public class YamlReader {
    private static final Logger log = LoggerFactory.getLogger(YamlReader.class);
    private static final String propertyChar = "\\.";
    private static final String defaultFileName = "application.yaml";
    private static final String defaultConfigPath = "config";

    private YamlReader(){}
    private static class SingletonHolder{
        private static final YamlReader instance = new YamlReader();
    }
    public static YamlReader getInstance(){
        return SingletonHolder.instance;
    }

    /**
     * 加载指定yaml文件,返回yaml文件key-value映射Map
     * @param fileName
     * @return
     */
    public Map<String, Object> loadFile(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream ;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(defaultConfigPath+ File.separator+ fileName));
        } catch (FileNotFoundException e) {
            log.error("config/{} 文件不存在,重定位到jar包resource下配置",fileName);
            inputStream = YamlReader.class.getClassLoader().getResourceAsStream(fileName);
        }

        Map<String, Object> obj = yaml.load(inputStream);
        return obj;
    }

    /**
     * 默认加载名为application.yaml配置文件
     * @return
     */
    public Map<String, Object> loadFile() {
        return loadFile(defaultFileName);
    }

    /**
     * 将指定yaml文件中固定属性前缀的配置信息，加载为指定类型Bean实例集合
     * @param fileName 指定yaml文件名
     * @param prefix 属性前缀
     * @param clz 加载Bean类信息
     * @param <T> 指定Bean类型
     * @return 前缀所对应的配置信息所对应的bean的集合
     * @throws Exception
     */
    public <T> List<T> loadBeanList(String fileName, String prefix, Class<T> clz) throws Exception {
        List<T> list = new ArrayList<>();
        Map<String, Object> map = loadFile(fileName);
        //拆分前缀
        if (prefix==null||"".equals(prefix)){
            T t = SerializationUtil.transObject(map,clz);
            list.add(t);
            return list;
        }else{
            String[] prefixArray = prefix.split(propertyChar);
            Object levelObj = map;
            for (int i = 0; i < prefixArray.length; i++) {
                levelObj = ((Map)levelObj).get(prefixArray[i]);
            }
            //如果是List，说明是目标对象配置为数组形式
            if (levelObj instanceof List){
               int size = ((List)levelObj).size();
                for (int i = 0; i < size; i++) {
                    T t = SerializationUtil.transObject(((List)levelObj).get(i),clz);
                    list.add(t);
                }
                return list;
            }
            //目标对象以键值对形式存在，且是一个对象
            if (levelObj instanceof Map){
                T t = SerializationUtil.transObject(levelObj,clz);
                list.add(t);
                return list;
            }
            if (levelObj instanceof String && String.class.getName().equals(clz.getName())){
                T t = (T) levelObj.toString();
                list.add(t);
                return list;
            }
            //其他类型的支持
            throw new Exception("yaml文件信息与前缀解析对象不匹配,请检查配置。如person.name无法解析为person对象。");
        }
    }

    /**
     * 将指定yaml文件中固定属性前缀的配置信息，加载为指定类型Bean实例
     * @param fileName 指定yaml文件名
     * @param prefix 属性前缀
     * @param clz 加载Bean类信息
     * @param <T> 指定Bean类型
     * @return
     * @throws Exception
     */
    public <T> T loadBean(String fileName, String prefix, Class<T> clz) throws Exception {
       List<T> list = loadBeanList(fileName,prefix,clz);
        return list.get(0);
    }
    /**
     * 默认将名为[application.yaml]的yaml文件中固定属性前缀的配置信息，加载为指定类型Bean实例集合，
     * @param prefix 属性前缀
     * @param clz 加载Bean类信息
     * @param <T> 指定Bean类型
     * @return 前缀所对应的配置信息所对应的bean的集合
     * @throws Exception
     */
    public <T> List<T> loadBeanList( String prefix, Class<T> clz) throws Exception {
        return loadBeanList(defaultFileName,prefix,clz);
    }

    /**
     * 默认将名为[application.yaml]文件中固定属性前缀的配置信息，加载为指定类型Bean实例
     * @param prefix 属性前缀
     * @param clz 加载Bean类信息
     * @param <T> 指定Bean类型
     * @return
     * @throws Exception
     */
    public <T> T loadBean(String prefix, Class<T> clz) throws Exception {
        List<T> list = loadBeanList(prefix,clz);
        return list.get(0);
    }

}
