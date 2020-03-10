package common;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

/**
 * @author duxing
 * @date 2019/07/16
 */
public class MyTest{
    int i = 1;

    public static void main(String[] args) {
        new MyTest();
    }

    @Test
    public void innerTest() {
        InterfaceTest1 interfaceTest1 = new InterfaceTest1();
//        InterfaceTest1.InnerTest innerTest = interfaceTest1.new InnerTest();
    }

    @Test
    public void nonoTest() {
//        long l = System.nanoTime();
//        long l1 = System.nanoTime();
//        System.out.println(l);
//        System.out.println(l1);
//        System.out.println(System.currentTimeMillis());
//        Date date = new Date();
//        System.out.println(date.getTime());
//        Instant now = Instant.now();
//        System.out.println("now:"+now);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println((int)((new Date().getTime() - System.currentTimeMillis()) / 1000));
    }

    @Test
    public void setTest() {
        HashSet<String> set = Sets.newHashSet();
        set.add("1");
        set.add("2");

        String[] objects = set.toArray(new String[set.size()]);
        System.out.println(objects);

    }

    @Test
    public void test() {
        int a = 1;
        int b = 1;
        int c = 1;
        System.out.println(++a < 0 & ++b > 0 & ++c > 0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        System.out.println();
    }

    @Test
    public void immutableListTest() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2);
        List<Integer> integers = Collections.unmodifiableList(list);
        list.add(3);
//        integers.add(4); //UnsupportedOperationException
        System.out.println(list);
        System.out.println(integers);
        Integer[] integers1 = integers.toArray(new Integer[0]);
        ArrayList<Integer> integers2 = Lists.newArrayList(integers1);
        System.out.println(integers1);
        System.out.println(integers2);

    }

    @Test
    public void regexTest() throws InterruptedException {
        String title = "中山(1)国际(上(1)海)";
        String title1 = "中山(1)国际(上海)";
        title = title.replaceAll("\\([\\S\\s]+?\\)", "");
        title1 = title1.replaceAll("(\\([^\\)]*\\))", "");

//        System.out.println(title);
//        System.out.println(title1);

        System.out.println(StringUtils.indexOfDifference("内蒙古自治", "内蒙古自治区"));
//        System.out.println(StringUtils.indexOfDifference("内蒙古自治区", "内蒙古自治区"));
//        System.out.println(StringUtils.indexOfDifference("内蒙古自治区", "内蒙古自治区") < "内蒙古自治区".length());
//        System.out.println("北京省".replaceAll("自治区|省|市|区|县|旗|镇", ""));
//        System.out.println(StringUtils.containsOnly("中国1", "中国"));
    }

    @Test
    public void bigDecimalTest() {
        System.out.println(new BigDecimal(2).multiply(new BigDecimal(100)).divide(new BigDecimal(14), 2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void arrayTest() {
        List<Integer> list = Lists.newArrayList(1, 3, 5);
        List<Integer> subList = list.subList(0, 1);
        list.remove(0);
        System.out.println(list);
        System.out.println(subList);
    }
}
