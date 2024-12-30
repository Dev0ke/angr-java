public class Solution2585 {
    private static final int MOD = (int) (1e9 + 7);

    public int waysToReachTarget(int target, int[][] types) {
        // 多重背包 求方案数
        long[] f = new long[target + 1];
        f[0] = 1L;

        for (int[] type : types) {
            int x = type[1], c = type[0];
//            for (int j = target; j >= x; j--) {
//                for (int k = 1; k <= c && k * x <= j; k++) {
//                    f[j] = (f[j] + f[j - k * x]) % MOD;
//                }
//            }

            long[] newF = f.clone();
            for (int j = x; j <= target; j++) {
                newF[j] += newF[j - x];
                newF[j] %= MOD;
                if (j >= (c + 1) * x) {
                    newF[j] -= f[j - (c + 1) * x];
                    newF[j] = (newF[j] % MOD + MOD) % MOD;
                }
            }
            f = newF;
        }
        return (int) f[target];
    }
}
/*
2585. 获得分数的方法数
https://leetcode.cn/problems/number-of-ways-to-earn-points/

第 335 场周赛 T4。

考试中有 n 种类型的题目。给你一个整数 target 和一个下标从 0 开始的二维整数数组 types ，其中 types[i] = [counti, marksi] 表示第 i 种类型的题目有 counti 道，每道题目对应 marksi 分。
返回你在考试中恰好得到 target 分的方法数。由于答案可能很大，结果需要对 10^9 +7 取余。
注意，同类型题目无法区分。
- 比如说，如果有 3 道同类型题目，那么解答第 1 和第 2 道题目与解答第 1 和第 3 道题目或者第 2 和第 3 道题目是相同的。
提示：
1 <= target <= 1000
n == types.length
1 <= n <= 50
types[i].length == 2
1 <= counti, marksi <= 50

多重背包求方案数。
时间复杂度 O(target * sum(count))
 */