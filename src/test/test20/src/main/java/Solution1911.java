import java.util.Arrays;

public class Solution1911 {
    private int[] nums;
    private long[][] memo;

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    // i:下标 j:0/1 偶数/奇数
    private long dfs(int i, int j) {
        if (i == nums.length) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        long res = dfs(i + 1, j); // 不选
        res = Math.max(res, dfs(i + 1, j ^ 1) + (j == 0 ? nums[i] : -nums[i])); // 选
        return memo[i][j] = res;
    }
}
/*
1911. 最大子序列交替和
https://leetcode.cn/problems/maximum-alternating-subsequence-sum/

第 55 场双周赛 T3。

一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。
- 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

记忆化搜索。
时间复杂度 O(n)
空间复杂度 O(n)
 */