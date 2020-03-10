package thinkinginjava;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author duxing
 * @date 2019/12/05
 */
public class ThreadTest {
    public static int count = 10000;

    @Test
    public void test() throws InterruptedException {
        System.out.println("start");
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("test");
//                while (count > 0) {
//                    System.out.println(count--);
//                }
//            }
//        };
        Thread t = new Thread(() -> {
            while (count > 0) {
                System.out.println(count--);
            }
        });
        t.setDaemon(false);

//        t.start();
//        t.run();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t);
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        //        while (true) {
//            Thread.sleep(1000L);
//        }

    }

    public static void main(String[] args) {
        System.out.println("start");
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("test");
//                while (count > 0) {
//                    System.out.println(count--);
//                }
//            }
//        };
        Handel handel = new Handel();
        Thread.setDefaultUncaughtExceptionHandler(handel);
        try {
            Thread t = new Thread(() -> {
                while (count > 0) {
                    System.out.println(count--);
                    throw new RuntimeException();
                }
            });
            t.start();
        } catch (Exception e) {
            System.out.println("1111" + e);
        }

//        t.setDaemon(true);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        t.run();
//        System.out.println(Thread.currentThread().getThreadGroup());
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(t);
//        executorService.shutdown();

    }

    static class Handel implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(e);
        }
    }

    @Test
    public void testWait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {

        }
    }

}
