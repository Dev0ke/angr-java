public class Solution1758 {
    public int minOperations(String s) {
        int len = s.length();
        // 0101...
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) - '0' == i % 2) {
                continue;
            }
            cnt++;
        }
        return Math.min(cnt, len - cnt);
    }
}
/*
1758. 生成交替二进制字符串的最少操作数
https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/

给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
返回使 s 变成 交替字符串 所需的 最少 操作数。
提示：
1 <= s.length <= 10^4
s[i] 是 '0' 或 '1'

模拟/计数
 */