package fit.jinyi.tool.test;

import com.alibaba.fastjson.JSONObject;
import fit.jinyi.tool.config.JsonFileReader;
import org.junit.Test;

/**
 * @author liujin
 * @date 2020/8/7
 * @since JDK8
 */
public class JsonTest {

    @Test
    public void test_jsonRead() {
        String fileName = "read.json";
        JSONObject jsonObject = JsonFileReader.getInstance().getJsonBean(fileName, JSONObject.class);
        System.out.println(jsonObject);
    }
}
