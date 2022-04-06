package fit.jinyi.tool.uid;

import java.io.File;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * JavaScript 执行工具类
 */
public class JavaScriptExeUtil {

    /**
     * 执行JavaScript脚本，返回 uuidDate
     * @return
     */
    public static String uuidDate() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        File file = new File("src/main/resources/uuid.js");
        try {
            engine.eval(new java.io.FileReader(file));
            Invocable invocable = (Invocable) engine;
            String newCallTime = (String) invocable.invokeFunction("uuidDate", 6);
            return newCallTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 执行JavaScript脚本，返回 uuid
     * @return
     */
    public static String uuid() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        File file = new File("src/main/resources/uuid.js");
        try {
            engine.eval(new java.io.FileReader(file));
            Invocable invocable = (Invocable) engine;
            String newCallTime = (String) invocable.invokeFunction("uuid", 10);
            return newCallTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


}
