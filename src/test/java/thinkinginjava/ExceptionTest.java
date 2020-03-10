package thinkinginjava;

import org.junit.jupiter.api.Test;


/**
 * @author duxing
 * @date 2019/07/30
 */
public class ExceptionTest {

    //RuntimeException不受检查
    @Test
    public void runtimeTest() throws TestException {
        throw new TestException();
    }

    //异常链
    public void test() {
        try {
            exceptionTest();
        } catch (Exception e) {
            try {
//                throw new TestException(e);
                throw e.getCause();
            } catch (TestException e1) {
                System.out.println("e1");
                e1.printStackTrace();
            } catch (Throwable ee) {
                System.out.println("ee");
                ee.printStackTrace();;
            }
        }
    }

    @Test
    public void testCase(){
        test();
    }

    public void exceptionTest() throws TestException {
        throw new TestException();
    }

}