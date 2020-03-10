package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;


import java.io.Serializable;
import java.util.*;

/**
 * @author duxing
 * @date 2019/06/17
 */
public class JoinerTest {

    @Test
    public void test() {

        System.out.println(Joiner.on("").skipNulls().join("1", null));

        String value1 = Joiner.on(",").join(Lists.newArrayList(1, "2", "1"));

        String value2 = Ints.join(";", 1, 2);

        ArrayList<Object> list = Lists.newArrayList("1", 22, "ccc");
        String value3 = Joiner.on(",").join(list);

        HashMap<String, String> map = Maps.newHashMap();
        map.put("2", "aaa");
        map.put("1", null);
        map.put("3", "eee");
//        Joiner.on("--").

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(Arrays.toString("兆丰广场|15".split("\\|")));

        String[]  s1 = new String[2];
        s1[1]= "1";
        String[] s2 = new String[2];
        System.arraycopy(s1, 0, s2, 0, 2);
//        s2[1] = "2";
        System.out.println(s1[1]);
        System.out.println(s2[1]);
    }

    @Test
    public void setTest(){
        HashSet<String> set = Sets.newHashSet();
        set.add("1");
        set.add("2");
        System.out.println(set.toArray());
        System.out.println(UUID.fromString(UUID.randomUUID().toString() + "1"));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @Test
    void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(calendar.getTime());


        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_WEEK, -1);
        System.out.println(calendar1.getTime());
    }
}
