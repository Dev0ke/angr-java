public class Solution2466 {
    private static final int MOD = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        // 以 0 结尾
        long[] f0 = new long[high + 1];
        long[] f1 = new long[high + 1];
        f0[zero] = 1;
        f1[one] = 1;

        long res = 0;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                f0[i] = Math.max(f0[i], (f0[i - zero] + f1[i - zero]) % MOD);
            }
            if (i - one >= 0) {
                f1[i] = Math.max(f1[i], (f0[i - one] + f1[i - one]) % MOD);
            }

            if (i >= low) {
                res += f0[i] + f1[i];
                res %= MOD;
            }
        }
        return (int) res;
    }
}
/*
2466. 统计构造好字符串的方案数
https://leetcode.cn/problems/count-ways-to-build-good-strings/

第 91 场双周赛 T2。

给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
将 '0' 在字符串末尾添加 zero  次。
将 '1' 在字符串末尾添加 one 次。
以上操作可以执行任意次。
如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 10^9 + 7 取余 后返回。
提示：
1 <= low <= high <= 10^5
1 <= zero, one <= low

动态规划
 */