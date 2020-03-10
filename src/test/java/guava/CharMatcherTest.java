package guava;

import com.google.common.base.CharMatcher;
import org.junit.jupiter.api.Test;


/**
 * @author duxing
 * @date 2019/06/17
 */
public class CharMatcherTest {
    @Test
    public void test() {
        //从字符串中得到/去掉所有数字
        String value1 = CharMatcher.DIGIT.removeFrom("dx 001 02abc!");
        String value2 = CharMatcher.DIGIT.retainFrom("dx 001 02abc!");

        String value3 = CharMatcher.is('a').retainFrom("dx 001 02abc!");

        String value4 = CharMatcher.WHITESPACE.removeFrom("dx 001 02abc!");

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
    }
}
