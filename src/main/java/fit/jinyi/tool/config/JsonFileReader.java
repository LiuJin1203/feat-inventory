package fit.jinyi.tool.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @author liujin
 * @describe
 */
public class JsonFileReader {
  private static final Logger log = LoggerFactory.getLogger(JsonFileReader.class);
  private static final String defaultConfigPath = "config";
  private JsonFileReader(){}

  private static class SingletonHolder{
    private static final JsonFileReader instance = new JsonFileReader();
  }
  public static JsonFileReader getInstance(){
    return SingletonHolder.instance;
  }

  /**
   *
   * @param fileName
   * @param clz
   * @param <R>
   * @return
   */
  public <R> R getJsonBean(String fileName,Class<R> clz) {
    return readJsonFromClassPath(fileName, clz);
  }

  private static <T> T readJsonFromClassPath(String fileName, Type type) {

    InputStream inputStream;
    try {
      try {
        inputStream = new BufferedInputStream(new FileInputStream(defaultConfigPath + File.separator+ fileName));
      } catch (FileNotFoundException e) {
        log.error("config/{} 文件不存在,重定位到jar包resource下配置",fileName);
        inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(fileName);
      }
      return JSON.parseObject(inputStream, StandardCharsets.UTF_8, type,
              // 自动关闭流
              Feature.AutoCloseSource,
              // 允许注释
              Feature.AllowComment,
              // 允许单引号
              Feature.AllowSingleQuotes,
              // 使用 Big decimal
              Feature.UseBigDecimal);
    } catch (IOException e) {
    e.printStackTrace();
  }
    throw new RuntimeException();
  }

}
