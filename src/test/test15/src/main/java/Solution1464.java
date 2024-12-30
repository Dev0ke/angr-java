public class Solution1464 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }
}
/*
1464. 数组中两元素的最大乘积
https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/

给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
请你计算并返回该式的最大值。
提示：
2 <= nums.length <= 500
1 <= nums[i] <= 10^3

数据范围不大，考虑直接暴力
时间复杂度 O(n^2)
 */