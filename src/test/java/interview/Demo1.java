package interview;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author duxing
 * @date 2019/12/25
 */
public class Demo1 {
    @Test
    public void sqrt1() {
        int num = 2;
        double precise = 0.0000000001;
        double result = num / 2;
        double last = num;
        while (!((Math.abs(result * result - num) > precise) && (Math.abs(result * result - num) < precise * 10))) {
            double temp = result;
            if (result * result < num) {
                result += Math.abs(last - result) / 2;
            } else {
                result -= Math.abs(last - result) / 2;
            }
            last = temp;
//            System.out.println(result);
        }
//        System.out.println("done" + result);
    }

    @Test
    public void sqrt2() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        double precise = 0.0000000001;
        double high = 1.5;
        double low = 1.4;
        double mid = (high + low) / 2;
        while (high - low > precise) {
            if (mid * mid < 2) {
                low = mid;
            } else {
                high = mid;
            }
//            System.out.println(mid);
            mid = (high + low) / 2;
        }
//        System.out.println("done" + mid);
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (Demo1.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 start");
//                Demo1.class.notify();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (Demo1.class) {
                for(int i = 1; i <= 10; i++) {
                    System.out.println("t2:i=" + i);
                    if (i == 5) {
                        Demo1.class.notify();
                        try {
                            Demo1.class.wait(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t2.start();
        t1.start();
    }
}
