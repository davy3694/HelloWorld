package common;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author duxing
 * @date 2019/07/16
 */
public class ExtendsTest {
    int i = 0;
    ExtendsTest(int i){
        test();
    }
    void test(){
        System.out.println("ExtendsTest,i=" + i);
    }

    public void print() {
        MyTest test = new MyTest();
        System.out.println(i);
    }

}
