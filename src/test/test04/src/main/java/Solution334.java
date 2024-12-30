public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) {
                return true;
            }
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            }
        }
        return false;
    }
}
/*
334. 递增的三元子序列
https://leetcode.cn/problems/increasing-triplet-subsequence/

给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 5 * 10^5
-2^31 <= nums[i] <= 2^31 - 1
进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？

设 first < second < third，若存在 third 则存在递增的三元子序列
若存在数 num < first，则更新 first
若存在数 first < num < second，则更新 second
时间复杂度 O(n)
空间复杂度 O(1)
 */