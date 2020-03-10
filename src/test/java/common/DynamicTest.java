package common;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author duxing
 * @date 2019/12/30
 */
public class DynamicTest {
    @Test
    public void testJs() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        String js = "function test(aaa) {\n" +
                "        return aaa;\n" +
                "    }";
        // 向脚本传递参数
//        engine.put("RESIDE_CITY", "440300");
        try {
            engine.eval(js);
            Invocable invoke = (Invocable) engine;
            try {
                TestClass testClass = new TestClass();
                Class<TestClass> testClassClass = TestClass.class;
                Field[] fields = testClassClass.getDeclaredFields();
                fields[1].setAccessible(true);
                System.out.println(fields[1].get(testClass));
                Object result = null;
                try {
                    result = (String) invoke.
                            invokeFunction("test", fields[1].get(testClass));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }

    public class TestClass{
        private int abc = 1;
        private String b = "dx";
    }
}
