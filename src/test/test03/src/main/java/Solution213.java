import java.util.Arrays;

public class Solution213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] arr1 = Arrays.copyOfRange(nums, 0, len - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, len);
        return Math.max(rob1(arr1, arr1.length), rob1(arr2, arr2.length));
    }

    private int rob1(int[] nums, int len) {
        int[] dp = new int[len];
        if (len == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
/*
213. 打家劫舍 II
https://leetcode.cn/problems/house-robber-ii/

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000

打家劫舍系列。难度升级，围成一个圈，即首尾不能同时偷。
有一种取巧的办法：沿用第 198 题的解法，取 [0, n-1] 与 [1, n] 二者中的最大值。
 */