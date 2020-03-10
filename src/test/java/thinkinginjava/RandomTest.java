package thinkinginjava;



import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author duxing
 * @date 2019/06/16
 */
public class RandomTest {
    //random类种子确定，随机数序列确定
    @Test
    public void testRandom() {
        Random random1 = new Random(100);
        Random random2 = new Random(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(String.format("random1:%s,random2:%s", random1.nextInt(), random2.nextInt()));
            System.out.println(String.format("random1:%s,random2:%s", random1.nextInt(10), random2.nextInt(10)));
            System.out.println(String.format("random1:%s,random2:%s", random1.nextInt(10), random2.nextInt(11)));
        }

    }
}
