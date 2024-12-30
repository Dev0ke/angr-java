import java.util.Arrays;

public class Solution2771 {
    private int[] nums1;
    private int[] nums2;
    private int n;
    private int[][] memo;

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n = nums1.length;

        memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    // 第 i 个数，从 nums_j 中选
    private int dfs(int i, int j) {
        if (i == n - 1) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 1;
        int[] nums = j == 0 ? nums1 : nums2;
        if (nums[i] <= nums1[i + 1]) {
            res = Math.max(res, dfs(i + 1, 0) + 1);
        }
        if (nums[i] <= nums2[i + 1]) {
            res = Math.max(res, dfs(i + 1, 1) + 1);
        }
        return memo[i][j] = res;
    }
}
/*
2771. 构造最长非递减子数组
https://leetcode.cn/problems/longest-non-decreasing-subarray-from-two-arrays/

第 353 场周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度均为 n 。
让我们定义另一个下标从 0 开始、长度为 n 的整数数组，nums3 。对于范围 [0, n - 1] 的每个下标 i ，你可以将 nums1[i] 或 nums2[i] 的值赋给 nums3[i] 。
你的任务是使用最优策略为 nums3 赋值，以最大化 nums3 中 最长非递减子数组 的长度。
以整数形式表示并返回 nums3 中 最长非递减 子数组的长度。
注意：子数组 是数组中的一个连续非空元素序列。
提示：
1 <= nums1.length == nums2.length == n <= 10^5
1 <= nums1[i], nums2[i] <= 10^9

记忆化搜索
注意 res 不能初始化为 0，要初始化为 1，子数组长度最少为 1
时间复杂度 O(n)
考虑题目改为 最长非递减子序列 做法：
对于每个 i，nums1[i] 和 nums2[i] 降序加到 nums，然后套 LIS 模板即可。（可扩展到 k 各数组情况 k > 2）
 */