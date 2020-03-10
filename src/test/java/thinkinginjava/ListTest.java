package thinkinginjava;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author duxing
 * @date 2019/07/26
 */
public class ListTest {
//    Arrays.asList 不能add
    @Test
    public void arrayListTest() {
        List<String> list = Arrays.asList("1", "2", "3");
//        list.add("4"); error
        System.out.println(list);
    }

    @Test
    public void nullListTest() {
        ArrayList<String> list = Lists.newArrayList();
        list.add("1");
        list.add(null);
        list.add("2");
        list.add(null);
        System.out.println(list);

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            String next = stringListIterator.next();
            stringListIterator.set("1");
            System.out.println(next);
        }
        System.out.println(list);
    }
}
