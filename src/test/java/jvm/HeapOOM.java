package jvm;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author duxing
 * @date 2020/02/18
 */
public class HeapOOM {
    static class OOMObject {}

    private int stackLength = 1;

    /**
     * -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void testOOM() {
        int i = 1;
        ArrayList<OOMObject> objects = Lists.newArrayList();
        while (true) {
            System.out.println(i++);
            objects.add(new OOMObject());
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    @Test
    public void testStackLeak() {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+ stackLength);
            e.printStackTrace();
        }
    }

    @Test
    public void methodArea() {
        Set<String> set = Sets.newHashSet();
        int i = 1;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }

    @Test
    public void stringIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str3 = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str1.intern() == str1);
        System.out.println(str3.intern() == str3);
        System.gc();

    }

    @Test
    public void testArray() {
        List list = new ArrayList();
        List<Integer> b2 = Lists.newArrayList(1,2,3);
        list.addAll(b2);
        list.addAll(b2);
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));


//        arrayList.addAll(Arrays.asList(array2));
//        Object[] array3 = arrayList.toArray();
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
//        System.out.println(Arrays.toString(array3));


    }

}
