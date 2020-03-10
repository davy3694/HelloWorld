package leetcode;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author duxing
 * @date 2020/01/03
 */
public class Solution {

    @Test
    public void test() {
//        System.out.println(resolve("ABCDEFGHIGKLMN", 4));
//        System.out.println(reverse(-123555));
//        System.out.println(myAtoi("-91283472332"));
        System.out.println(isPalindrome(121));
    }

    /**
     * 6、Z字形变幻
     *
     * @param s
     * @param num
     * @return
     */
    public String resolve(String s, int num) {
        if (s == null || num <= 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList();
        for (int i = 0; i < Math.min(s.length(), num); i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == num - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    /**
     * 7、整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        int pop;
        do {
            pop = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + pop;
            x /= 10;
        } while (x != 0);
        return result;
    }

    /**
     * 字符串转整数
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int result = 0;
        char preChar = ' ';
        boolean negative = true;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && c - '0' > 7) ) {
                    return negative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + c - '0';
            } else if (Character.isDigit(preChar)) {
                break;
            } else if (preChar != ' ' && preChar != '+' && preChar != '-') {
                return 0;
            } else if (c == ' ') {
                if (Character.isDigit(preChar)) {
                    break;
                } else if (preChar == ' ') {

                } else {
                    break;
                }
            } else if (preChar == ' ' && (c == '-' || c == '+')) {

            } else if (result > 0) {
                return negative ? result : -result;
            } else {
                return 0;
            }
            if (c == '-') {
                negative = false;
            }
            preChar = c;
        }
        return negative ? result : -result;
    }

    /**
     * 回文数字
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        char[] chars = String.valueOf(x).toCharArray();
//        int len = chars.length;
//        int index = 0;
//        int mid = (len + 1) / 2;
//        boolean even = len % 2 == 0;
//        while (chars[len - index - 1] == chars[index]) {
//            if ((even && index < mid) || (!even && index < mid -1)) {
//                index++;
//            } else {
//                break;
//            }
//        }
//        return (even && index == mid) || (!even && index + 1 == mid);

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || rev / 10 == x;
    }
}
