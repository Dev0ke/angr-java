public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, getGCD(str1.length(), str2.length()));
        }
        return "";
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
1071. 字符串的最大公因子
https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/

对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
提示：
1 <= str1.length, str2.length <= 1000
str1 和 str2 由大写英文字母组成

数学。
如果 str1 和 str2 拼接后等于 str2 和 str1 拼接起来的字符串，那么一定存在符合条件的字符串 x。
时间复杂度 O(n)。
 */