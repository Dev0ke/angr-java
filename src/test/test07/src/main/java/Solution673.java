public class Solution673 {
    /**
     * 动态规划
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int ans = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
/*
673. 最长递增子序列的个数
https://leetcode.cn/problems/number-of-longest-increasing-subsequence/

给定一个未排序的整数数组，找到最长递增子序列的个数。
输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
提示:
1 <= nums.length <= 2000
-10^6 <= nums[i] <= 10^6

LIS 进阶版。LIS 有两种解法，动态规划 O(n^2) 和 贪心+二分 O(nlogn)
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */