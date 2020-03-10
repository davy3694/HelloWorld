package guava;

import com.google.common.io.Files;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author duxing
 * @date 2019/06/17
 */
public class FileTest {
    @Test
    public void readFile() {
        try {
            List<String> texts = Files.readLines(new File("/Users/admin/Desktop/test"), Charset.defaultCharset());
            System.out.println(texts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
