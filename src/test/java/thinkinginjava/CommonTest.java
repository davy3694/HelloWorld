package thinkinginjava;

import com.google.common.collect.Lists;
import common.InterfaceTest1;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author duxing
 * @date 2019/06/21
 */
public class CommonTest {
    @Test
    public void lableTest() {
        out:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 3) {
                    System.out.println("break");
                    break out;
//                    continue out;
                }
                System.out.println("out");
            }
        }
        System.out.println(11111);
    }
    @Test
    public void test() {
        List<String> list = Lists.newArrayList("111", "222");
        List<String> collect = list.stream().filter(e -> e.equals("1")).collect(Collectors.toList());
         list = list.stream().filter(e -> e.equals("111")).collect(Collectors.toList());
        System.out.println();
    }

    @Test
    public void testBetween(){
        long time = new Date().getTime();
        System.out.println(time);
        boolean value = Range.between(new Date(1562134210699l - 1l), new Date(1562134210699l - 1l)).contains(new Date(1562134210699l));
        System.out.println(value);
    }

    @Test
    public void testArraySort() {
        int[] arr = {1, 2, 3};
        int[] arr2 = arr.clone();
        ArrayUtils.reverse(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr == arr2);
    }

    @Test
    public void testInnerClass(){
//        InterfaceTest1 interfaceTest1 = new InterfaceTest1();
        StaticTest.test();
    }

    @Test
    void testTimeUnit() {
        try {
            System.out.println("start");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("end");
            long l = TimeUnit.HOURS.toSeconds(1);
            System.out.println(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
