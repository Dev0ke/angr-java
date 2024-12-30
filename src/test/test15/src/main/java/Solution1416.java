public class Solution1416 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfArrays(String S, int k) {
        int n = S.length();
        char[] s = S.toCharArray();
        // f[i] 表示前 i 个数字进行恢复的方案数
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            long num = 0, base = 1;
            // 倒序枚举 j，最多只需要枚举 10 个
            for (int j = i - 1; j >= 0 && i - j <= 10; --j) {
                // 在高位添加当前的数字，得到第 j+1 到 i 个数字组成的数
                // 注意 s 的下标是从 0 开始的
                num += (s[j] - '0') * base;
                if (num > (long) k) {
                    break;
                }
                // 判断是否有前导 0
                if (s[j] != '0') {
                    f[i] += f[j];
                    f[i] %= MOD;
                }
                base *= 10;
            }
        }
        return (int) f[n];
    }
}
/*
1416. 恢复数组
https://leetcode.cn/problems/restore-the-array/description/

某个程序本来应该输出一个整数数组。但是这个程序忘记输出空格了以致输出了一个数字字符串，我们所知道的信息只有：数组中所有整数都在 [1, k] 之间，且数组中的数字都没有前导 0 。
给你字符串 s 和整数 k 。可能会有多种不同的数组恢复结果。
按照上述程序，请你返回所有可能输出字符串 s 的数组方案数。
由于数组方案数可能会很大，请你返回它对 10^9 + 7 取余 后的结果。
提示：
1 <= s.length <= 10^5.
s 只包含数字且不包含前导 0 。
1 <= k <= 10^9.

递推。
时间复杂度 O(nlogk)。
相似题目: 91. 解码方法
https://leetcode.cn/problems/decode-ways/
 */