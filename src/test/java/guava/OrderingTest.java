package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duxing
 * @date 2019/09/30
 */
public class OrderingTest {

    @Test
    public void test() {
        ArrayList<Integer> integers = Lists.newArrayList(3, 1, 5, 2);
        //找出集合中最大的几个
        List<Integer> es = Ordering.natural().greatestOf(integers.iterator(), 3);
        Integer min = Ordering.natural().min(1, 4, 5, 2);
        System.out.println(es);
        System.out.println(min);
    }
}
