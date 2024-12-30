import java.util.Arrays;

public class Solution3351 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int mx = (int) (1e5 + 5);

    public int sumOfGoodSubsequences(int[] nums) {
        long[] cnt = new long[mx];
        long[] sum = new long[mx];
        for (int v : nums) {
            sum[v] = (sum[v] + v) % MOD;
            cnt[v] = (cnt[v] + 1) % MOD;
            sum[v] = (sum[v] + sum[v + 1] + cnt[v + 1] * v) % MOD;
            cnt[v] = (cnt[v] + cnt[v + 1]) % MOD;
            if (v - 1 < 0) continue;
            sum[v] = (sum[v] + sum[v - 1] + cnt[v - 1] * v) % MOD;
            cnt[v] = (cnt[v] + cnt[v - 1]) % MOD;
        }
        long ans = Arrays.stream(sum).sum();
        return (int) (ans % MOD);
    }
}
/*
3351. 好子序列的元素之和
https://leetcode.cn/problems/sum-of-good-subsequences/description/

第 423 场周赛 T3。

给你一个整数数组 nums。好子序列 的定义是：子序列中任意 两个 连续元素的绝对差 恰好 为 1。
子序列 是指可以通过删除某个数组的部分元素（或不删除）得到的数组，并且不改变剩余元素的顺序。
返回 nums 中所有 可能存在的 好子序列的 元素之和。
因为答案可能非常大，返回结果需要对 10^9 + 7 取余。
注意，长度为 1 的子序列默认为好子序列。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

子序列计数 DP。
时间复杂度 O(n)。
 */