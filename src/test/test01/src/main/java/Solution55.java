public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] == 0) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        }
        return true;
    }
}
/*
55. 跳跃游戏
https://leetcode.cn/problems/jump-game/

给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。
提示：
1 <= nums.length <= 3 * 10^4
0 <= nums[i] <= 10^5

贪心。
 */