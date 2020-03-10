package common;

import com.google.common.primitives.Ints;
import org.apache.commons.lang.math.NumberUtils;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

/**
 * @author duxing
 * @date 2019/07/17
 */
public class InterfaceTest1 implements InterfaceTest{
    public InterfaceTest1(){
        System.out.println("1");
    }

    @Override
    public void print() throws NullPointerException{
        System.out.println(1);
    }

    @Test
    public void test() {
        System.out.println("0");
//        InterfaceTest test = new InterfaceTest();


    }
    static class InnerTest{
        InnerTest(){
            System.out.println("2");
        }
    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal("0.00000001");
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal.toPlainString());
//        Ints.tryParse()
    }

    @Test
    public void test2() {
        System.out.println(Ints.tryParse("3164967865"));
        System.out.println(NumberUtils.toInt("3164967865"));
    }
}
