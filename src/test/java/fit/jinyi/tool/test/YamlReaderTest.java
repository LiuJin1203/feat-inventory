package fit.jinyi.tool.test;


import fit.jinyi.tool.config.YamlReader;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author liujin
 * @date 2020/8/4
 * @since JDK8
 */
public class YamlReaderTest {
    String yaml_file = "application.yaml";

    @Test
    public void test_loadBean() {
        GrpcInfo grpcInfo = null;
        try {
            grpcInfo = YamlReader.getInstance().loadBean("grpc.clients", GrpcInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[test_loadBean]:" + grpcInfo);
    }
    @Test
    public void test_loadFile() {
        Map<String, Object> map = YamlReader.getInstance().loadFile();
        System.out.println("[test_loadFile]:" + map);
    }
    @Test
    public void test_loadBeanList() {
        List<GrpcInfo> grpcInfoList = null;
        try {
            grpcInfoList = YamlReader.getInstance().loadBeanList("grpc.clients", GrpcInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[test_loadBeanList]:" + grpcInfoList);
    }
}
