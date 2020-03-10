package guava;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.junit.jupiter.api.Test;


/**
 * @author duxing
 * @date 2019/06/17
 */
public class HashingTest {

    @Test
    public void md5() {
        String md5 = Hashing.md5()
                .newHasher()
                .putString("dx", Charsets.UTF_8)
                .hash()
                .toString();
        System.out.println(md5);
    }
}
