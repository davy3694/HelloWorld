package common;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author duxing
 * @date 2019/09/04
 */
public class UnitTest {

    @Test
    @DisplayName("测试方法1")
    void test1() {
        System.out.println("测试方法1");
    }

    @Test
    @Disabled
    @DisplayName("测试方法2")
    void test2() {

    }

    @Test
    @RepeatedTest(10)
    void test3() {
        System.out.println("test3");
    }
}
