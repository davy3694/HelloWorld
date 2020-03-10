package guava;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author duxing
 * @date 2019/06/17
 */
public class SplitterTest {
    @Test
    public void test() {
        Iterable<String> value1 = Splitter.on(",").limit(2).split("dx,,,12, 3");

        //字符串分割转map
        Map<String, String> value2 = Splitter.on(";").trimResults().withKeyValueSeparator(":").split("key1: 1; key2: 2  ; key3: 3");

        Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();
        Iterable<String> value3 = splitter.limit(2).omitEmptyStrings().split("dx,,,12,    3");

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
