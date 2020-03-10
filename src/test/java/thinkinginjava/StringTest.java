package thinkinginjava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author duxing
 * @date 2019/08/01
 */
public class StringTest {


    @Override
    public String toString() {
//        return "StringTest{}" + this;
        return "StringTest{}" + super.toString();
    }

    @Test
    //tostring方法打印对象信息中用this报错，应用super.tostring
    //递归调用报错
    public void testToString() {
        System.out.println("StringTest" + this);
    }

    @Test
    public void equalsTest() {
        String a = "abc";
        String b = "abc";
        String c = "ab" + "c";
        System.out.println(a == b);
        System.out.println(b == c);
    }

    @Test
    public void formatTest() {
        System.out.println(String.format("%-5s--%5d", "1", 1));
    }

    @Test
    public void plusTest() {
        System.out.println("+");
        System.out.println("\\".matches("\\\\"));
        System.out.println(Arrays.toString("abc def".split("b")));
        System.out.println(String.join("w",new String[]{"11", "222"}));
        System.out.println(String.join("w", Lists.newArrayList("1", "2")));
    }

    @Test
    public void regexTest() {
        String DATE_STRING = "2017-04-25";
        String P_COMM = "(\\d{4})-((\\d{2})-(\\d{2}))";
        Pattern pattern = Pattern.compile(P_COMM, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(DATE_STRING);
        matcher.find(0);//必须要有这句
        System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));
        System.out.printf("\nmatcher.group(1) value:%s", matcher.group(1));
        System.out.printf("\nmatcher.group(2) value:%s", matcher.group(2));
        System.out.printf("\nmatcher.group(3) value:%s", matcher.group(3));
        System.out.printf("\nmatcher.group(4) value:%s", matcher.group(4));
    }

    @Test
    public void regexTest2() {
        String DATE_STRING = "abCcabcabc";
        String P_COMM = "abc*";
        Pattern pattern = Pattern.compile(P_COMM, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(DATE_STRING);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(DATE_STRING.replaceAll("abc*", "e"));
        if (matcher.matches()) {
            System.out.println("matcher" + matcher.group());
        }
        Scanner s = new Scanner(System.in);
        System.out.println();
        while (s.hasNext()) {
            System.out.println(s.next());
        }

    }

    @Test
    public void replace() {
        String template = "您的$$name#$门票购买成功，演出地点$$place#$，请与$$time#$准时入场！";
        Map<String, String> params = Maps.newHashMap();
        params.put("place", "上海大剧院");
        params.put("name", "xx喜剧");
        params.put("time", "2019-09");

        Pattern p = Pattern.compile("\\$\\$.*?#\\$");
        Matcher matcher = p.matcher(template);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        matcher.reset();
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, params.get(matcher.group().substring(2, matcher.group().length()-2)));
        }
//        matcher.appendTail(sb);
        System.out.println(sb.toString());

    }
}
