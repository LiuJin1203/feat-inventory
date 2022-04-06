package fit.jinyi.tool.test;

import fit.jinyi.tool.uid.JavaScriptExeUtil;
import org.junit.Test;


/**
 *
 */
public class JavaScriptExe {
    @Test
    public void generate_uid(){
        String js_uid = JavaScriptExeUtil.uuid();
        System.out.println(js_uid);
    }
    @Test
    public void generate_uuidDate(){
        String js_uid = JavaScriptExeUtil.uuidDate();
        System.out.println(js_uid);
    }
}
