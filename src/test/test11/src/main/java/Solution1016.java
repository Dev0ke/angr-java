public class Solution1016 {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
/*
1016. 子串能表示从 1 到 N 数字的二进制串
https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/

给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
子字符串 是字符串中连续的字符序列。
提示：
1 <= s.length <= 1000
s[i] 不是 '0' 就是 '1'
1 <= n <= 10^9

模拟。
时间复杂度 O(m·min(mn)logmin(mn))
 */