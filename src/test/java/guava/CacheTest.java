package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author duxing
 * @date 2019/12/31
 */
public class CacheTest {
    @Test
    public void testCreate() {
        LoadingCache<String, String> build = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println(111);
                        return "1";
                    }
                });
        try {
            String s = build.get("2");
            System.out.println(222);
//            String s = build.get("1", (Callable<String>) () -> {
//                TimeUnit.SECONDS.sleep(1);
//                return "2";
//            });

            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
