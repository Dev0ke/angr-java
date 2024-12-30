public class Solution639 {
    private static final int MOD = (int) (1e9 + 7);

    public int numDecodings(String s) {
        int n = s.length();
        // 初始状态：空字符串可以有 1 种解码方法，解码出一个空字符串。
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    private int check1digit(char c1) {
        // 无解
        if (c1 == '0') return 0;
        // [1, 9]
        if (c1 == '*') return 9;
        // 唯一确定的
        return 1;
    }

    private int check2digits(char c1, char c2) {
        // [11, 19] + [21, 26]
        if (c1 == '*' && c2 == '*') return 15;
        if (c1 == '*') {
            // 1x or 2x（11,12,13,14,15,16 or 21,22,23,24,25,26）
            if (c2 <= '6') return 2;
            // 1x（17,18,19）
            return 1;
        }
        if (c2 == '*') {
            // [11, 19]
            if (c1 == '1') return 9;
            // [21, 26]
            if (c1 == '2') return 6;
            // 无解
            return 0;
        }
        return (c1 != '0' && (c1 - '0') * 10 + (c2 - '0') <= 26) ? 1 : 0;
    }
}
/*
639. 解码方法 II
https://leetcode.cn/problems/decode-ways-ii/description/

一条包含字母 A-Z 的消息通过以下的方式进行了 编码 ：
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
"AAJF" 对应分组 (1 1 10 6)
"KJF" 对应分组 (11 10 6)
注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。
例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
由于答案数目可能非常大，返回 10^9 + 7 的 模 。
提示：
1 <= s.length <= 10^5
s[i] 是 0 - 9 中的一位数字或字符 '*'

动态规划。
时间复杂度 O(n)。
相似题目: 91. 解码方法
https://leetcode.cn/problems/decode-ways/
 */