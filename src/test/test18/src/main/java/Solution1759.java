public class Solution1759 {
    private static final int MOD = (int) (1e9 + 7);

    public int countHomogenous(String s) {
        long res = 0L;
        char pre = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == pre) {
                cnt++;
            } else {
                res = (res + (cnt + 1L) * cnt / 2) % MOD;
                pre = ch;
                cnt = 1;
            }
        }
        res = (res + (cnt + 1L) * cnt / 2) % MOD;
        return (int) res;
    }
}
/*
1759. 统计同构子字符串的数目
https://leetcode.cn/problems/count-number-of-homogenous-substrings/

给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 10^9 + 7 取余 后的结果。
同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
子字符串 是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 10^5
s 由小写字符串组成

数学。
一个长度为 m 的字符串的子字符串数目为 m(m+1)/2
 */