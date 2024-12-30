import java.util.Arrays;

public class Solution628 {
    public int maximumProduct(int[] nums) {
        // 3 <= nums.length <= 10^4
        int len = nums.length;

        Arrays.sort(nums);
        // 全是正数或者全是负数情况下，最大三个数乘积
        int res1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        // 或者为最小两个负数 与 最大正数 的乘积
        int res2 = nums[0] * nums[1] * nums[len - 1];
        return Math.max(res1, res2);
    }
}
/*
628. 三个数的最大乘积
https://leetcode.cn/problems/maximum-product-of-three-numbers/

给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
提示：
3 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000

分类讨论
case1: 全是正数或者全是负数情况下，最大三个数乘积
case2: 为最小两个负数 与 最大正数 的乘积
时间复杂度 O(nlogn) 可线性遍历优化至 O(n)
 */