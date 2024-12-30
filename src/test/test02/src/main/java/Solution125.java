import java.util.Locale;

public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 只考虑字母和数字字符，可以忽略字母的大小写
        String str = s.toLowerCase(Locale.ENGLISH).replaceAll("[^0-9a-z]+", "");
        int len = str.length();
        for (int left = 0; left < len / 2; left++) {
            int right = len - 1 - left;
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
/*
125. 验证回文串
https://leetcode.cn/problems/valid-palindrome/

如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
字母和数字都属于字母数字字符。
给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
提示：
1 <= s.length <= 2 * 10^5
s 仅由可打印的 ASCII 字符组成

step1 字符串转小写，去掉非数字和字母
step2 从两侧到中心逐个字符进行比较
 */