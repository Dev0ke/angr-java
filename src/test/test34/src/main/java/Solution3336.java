import java.util.Arrays;

public class Solution3336 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MAX_N = 205;
    private int[] nums;
    private long[][][] memo;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new long[n][MAX_N][MAX_N];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) ((dfs(n - 1, 0, 0) - 1 + MOD) % MOD);
    }

    // 表示在 nums[0] 到 nums[i] 中选数字，且当前两个子序列的 GCD 分别为 j,k 时，最终可以得到的合法子序列对的个数。
    private long dfs(int i, int j, int k) {
        if (i < 0) return j == k ? 1 : 0;
        if (memo[i][j][k] != -1) return memo[i][j][k];
        long res = dfs(i - 1, j, k);
        res += dfs(i - 1, getGCD(j, nums[i]), k);
        res += dfs(i - 1, j, getGCD(k, nums[i]));
        return memo[i][j][k] = res % MOD;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3336. 最大公约数相等的子序列数量
https://leetcode.cn/problems/find-the-number-of-subsequences-with-equal-gcd/description/

第 421 场周赛 T3。

给你一个整数数组 nums。
请你统计所有满足以下条件的 非空 子序列 对 (seq1, seq2) 的数量：
- 子序列 seq1 和 seq2 不相交，意味着 nums 中 不存在 同时出现在两个序列中的下标。
- seq1 元素的 GCD 等于 seq2 元素的 GCD。
返回满足条件的子序列对的总数。
由于答案可能非常大，请返回其对 10^9 + 7 取余 的结果。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 200

多维 DP
https://leetcode.cn/problems/find-the-number-of-subsequences-with-equal-gcd/solutions/2967084/duo-wei-dppythonjavacgo-by-endlesscheng-5pk3/
rating 2376 (clist.by)
 */