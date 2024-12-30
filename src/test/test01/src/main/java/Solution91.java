public class Solution91 {
    public int numDecodings(String s) {
        int len = s.length();
        // 预处理
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = s.charAt(i) - '0';
        }

        // f[i] 表示 s[0, i-1] 的解码方法数
        int[] f = new int[len + 1];
        f[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            // 使用 1 个字符
            if (num[i - 1] != 0) {
                f[i] += f[i - 1];
            }
            // 使用 2 个字符
            if (i - 2 >= 0 && num[i - 2] != 0 && num[i - 2] * 10 + num[i - 1] <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[len];
    }
}
/*
91. 解码方法
https://leetcode.cn/problems/decode-ways/

一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
- "AAJF" ，将消息分组为 (1 1 10 6)
- "KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
题目数据保证答案肯定是一个 32 位 的整数。
提示：
1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。

动态规划。
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 剑指 Offer 46. 把数字翻译成字符串
https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
1416. 恢复数组
https://leetcode.cn/problems/restore-the-array/description/
 */
