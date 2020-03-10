package thinkinginjava;

/**
 * @author duxing
 * @date 2019/07/26
 */
public class InnerClassTest {
    InnerClassTest(){
        System.out.println("1");
    }

    class InnerTest{
        InnerTest(){
            System.out.println("2");
        }
    }
}