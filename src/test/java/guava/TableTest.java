package guava;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.Map;

/**
 * @author duxing
 * @date 2019/09/30
 */
public class TableTest {
    @Test
    public void test() {
        HashBasedTable<String, String, Integer> table = HashBasedTable.create();
        table.put("A", "B", 1);
        table.put("A", "C", 2);
        table.put("A", "C", 3);
        Map<String, Map<String, Integer>> stringMapMap = table.columnMap();
        System.out.println(stringMapMap);
        System.out.println(table);
        System.out.println(table.values());

    }
}
