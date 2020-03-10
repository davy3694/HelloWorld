package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Collections;

/**
 * @author duxing
 * @date 2019/08/12
 */
public class IntsTest {
    @Test
    public void test() {
        boolean value1 = Ints.contains(new int[]{1, 2}, 0);
        System.out.println(Ints.tryParse("1"));
        System.out.println(Arrays.toString(Ints.ensureCapacity(new int[]{1, 2, 3}, 30, 2)));
    }

}
