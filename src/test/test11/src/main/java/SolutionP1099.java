public class SolutionP1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
/*
$1099. 小于 K 的两数之和
https://leetcode.cn/problems/two-sum-less-than-k/

第 3 场双周赛 T1。

给你一个整数数组 nums 和整数 k ，返回最大和 sum ，满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。如果没有满足此等式的 i,j 存在，则返回 -1 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000

数据量范围最大 100，直接时间复杂度 O(n^2) 暴力即可。
 */