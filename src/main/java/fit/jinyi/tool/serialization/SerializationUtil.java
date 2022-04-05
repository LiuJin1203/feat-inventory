package fit.jinyi.tool.serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @description: 序列化工具, 将序列化实现细节隐藏
 */
public class SerializationUtil {


  /**
   * 将对象序列化成字符串
   */
  public static String toJSONString(Object object) {
    return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
  }

  /**
   * 将字符串反序列化成对象
   */
  public static <T> T parseObject(String objStr, Class<T> clazz) {
    return JSON.parseObject(objStr, clazz);
  }

  /**
   * 将字符串反序列化成列表对象
   */
  public static <T> List<T> parseArray(String objStr, Class<T> clazz) {
    return JSON.parseArray(objStr, clazz);
  }

  /**
   * 对象深拷贝
   *
   * @param object 原始对象
   * @param clazz 目标转换对象
   * @param <T> 目标转换对象类型
   */
  public static <T> T transObject(Object object, Class<T> clazz) {
    return parseObject(toJSONString(object), clazz);
  }


  /**
   * 列表数据深拷贝
   *
   * @param objects 原始对象列表
   * @param clazz 目标转换对象
   * @param <T> 目标转换对象类型
   */
  public static <T> List<T> transArray(List<?> objects, Class<T> clazz) {
    return parseArray(toJSONString(objects), clazz);
  }

  /**
   * 从文件中读取对象JSON并转为相应对象
   *
   * @param path 文件路径
   * @return 相应对象
   */
  public static String readJsonObjectFromFile(String path) {
    String jsonStr = "";
    try {
      File jsonFile = new File(path);
      FileReader fileReader = new FileReader(jsonFile);

      Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
      int ch = 0;
      StringBuffer sb = new StringBuffer();
      while ((ch = reader.read()) != -1) {
        sb.append((char) ch);
      }
      fileReader.close();
      reader.close();
      jsonStr = sb.toString();
      return jsonStr;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * 将对象的json串写入到文件
   *
   * @param path 文件路径
   * @param ob 待写入对象
   */
  public static void writeObjectJsonToFile(String path, Object ob) {
    Path targetPath = Paths.get(path);
    try {
      Files.deleteIfExists(targetPath);
      Files.createFile(targetPath);
      Files.write(targetPath, JSON.toJSONString(ob).getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * object->jsonObject
   */
  public static JSONObject toJSONObject(Object obj){
    return transObject(obj,JSONObject.class);
  }
  /**
   *  jsonString->jsonObject
   */
  public static JSONObject toJSONObject(String jsonString){
    return JSONObject.parseObject(jsonString);
  }

  /**
   * object->JSONArray
   * obj instanceof Collection
   * @param obj
   * @return
   */
  public static JSONArray toJSONArray(Object obj) {
    return JSONArray.parseArray(SerializationUtil.toJSONString(obj));
  }
}
