package guava;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author duxing
 * @date 2019/09/10
 */
public class SetTest {
    @Test
    public void test() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3,4,5);
        Set<Integer> difference = Sets.difference(s1, s2);
        System.out.println(difference);

        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("1", "2");
        System.out.println(map);

        Map<String, String> map1 = Maps.newIdentityHashMap();
        map1.put(new String("1"), "1");
        map1.put(new String("1"), "2");
        map1.put("1", "2");
        map1.put("1", "2");
        System.out.println(map1);

        System.out.println(Boolean.getBoolean("true"));
    }

    @Test
    public void getLevenshteinDistance() {
        System.out.println(StringUtils.getLevenshteinDistance("上街村","上1街组"));
        System.out.println(StringUtils.indexOfDifference("上街村","上1街组"));
        System.out.println(StringUtils.difference("上街村", "上1街组"));
        System.out.println(StringUtils.difference("a1b", "ab1xyz"));
        System.out.println("33.3(111)222".replaceAll("\\([\\S\\s]+?\\)", ""));
        System.out.println(StringUtils.removeStart("中国上海中国", "中国1"));
    }

    @Test
    void testCycle() {
        Iterable<String> cycle = Iterables.cycle("1", "2", "3");
//        cycle.forEach(System.out::println);
        Iterator<String> iterator = cycle.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void hash() throws NoSuchAlgorithmException {
        String input = "dx";
        System.out.println(Hashing.md5().hashBytes(input.getBytes()).toString());
    }


}
