import java.util.Arrays;

public class Solution3176 {
    private int[] nums;
    private int[][] memo;

    public int maximumLength(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        memo = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, k));
        }
        return ans + 1;
    }

    // 以 nums[i] 结尾的、有至多 j 对 相邻元素不同 最长子序列的长度
    private int dfs(int i, int j) {
        if (i == 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        for (int p = 0; p < i; p++) {
            if (nums[p] != nums[i]) {
                if (j - 1 >= 0) res = Math.max(res, dfs(p, j - 1) + 1);
            } else {
                res = Math.max(res, dfs(p, j) + 1);
            }
        }
        return memo[i][j] = res;
    }
}
/*
3176. 求出最长好子序列 I
https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/description/

第 132 场双周赛 T3。

给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
请你返回 nums 中 好 子序列 的最长长度
提示：
1 <= nums.length <= 500
1 <= nums[i] <= 10^9
0 <= k <= min(nums.length, 25)

记忆化搜索。
时间复杂度 O(n^2 * k)
 */