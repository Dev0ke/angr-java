import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution8 {
    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUMBER = "in_number";
    private static final String END = "end";

    private static final Map<String, String[]> TRANSFER;

    static {
        TRANSFER = new HashMap<>();
        TRANSFER.put(START, new String[]{START, SIGNED, IN_NUMBER, END});
        TRANSFER.put(SIGNED, new String[]{END, END, IN_NUMBER, END});
        TRANSFER.put(IN_NUMBER, new String[]{END, END, IN_NUMBER, END});
        TRANSFER.put(END, new String[]{END, END, END, END});
    }

    private int sign = 1;
    private long ans = 0;
    private String state = START;

    public int myAtoi(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            get(s.charAt(i));
        }
        return (int) (sign * ans);
    }

    private void get(char ch) {
        state = TRANSFER.get(state)[getCol(ch)];
        if (IN_NUMBER.equals(state)) {
            ans = ans * 10 + ch - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if (SIGNED.equals(state)) {
            sign = ch == '+' ? 1 : -1;
        }
    }

    private int getCol(char ch) {
        if (ch == ' ') {
            return 0;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (Character.isDigit(ch)) {
            return 2;
        }
        return 3;
    }

    // 模拟
    public int myAtoi2(String s) {
        // 忽略前导空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();

        int res = 0;
        int sign = chars[0] == '-' ? -1 : 1;
        int beginIdx = (chars[0] == '+' || chars[0] == '-') ? 1 : 0;
        for (int i = beginIdx; i < len; i++) {
            int digit = chars[i] - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return sign * res;
    }

    private static final Pattern pattern = Pattern.compile("^[+-]?\\d+");

    // 正则表达式
    public int myAtoi3(String s) {
        s = s.trim();
        Matcher matcher = pattern.matcher(s);
        if (!matcher.find()) {
            return 0;
        }
        String str = matcher.group();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
/*
8. 字符串转换整数 (atoi)
https://leetcode.cn/problems/string-to-integer-atoi/

请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
函数 myAtoi(string s) 的算法如下：
1.读入字符串并丢弃无用的前导空格
2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
5.如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
6.返回整数作为最终结果。
注意：
- 本题中的空白字符只包括空格字符 ' ' 。
- 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
提示：
0 <= s.length <= 200
s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成

自动机。
时间复杂度 O(n)
空间复杂度 O(1)
同: 剑指 Offer 67. 把字符串转换成整数
https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */