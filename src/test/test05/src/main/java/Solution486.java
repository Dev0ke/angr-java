public class Solution486 {
    /**
     * 递归
     * 时间复杂度 O(2^n)
     */
    public boolean PredictTheWinner(int[] nums) {
        // 偶数情况同 877
        int len = nums.length;
        if (len % 2 == 0) {
            return true;
        }
        return play(nums, 0, len - 1) >= 0;
    }

    private int play(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        int chooseLeft = nums[left] - play(nums, left + 1, right);
        int chooseRight = nums[right] - play(nums, left, right - 1);
        return Math.max(chooseLeft, chooseRight);
    }

    /**
     * 动态规划
     * 时间复杂度 O(n^2)
     */
    public boolean PredictTheWinner2(int[] nums) {
        int len = nums.length;
        // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，即在下标范围 [i,j] 中，当前玩家与另一个玩家的分数之差的最大值
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
/*
486. 预测赢家
https://leetcode.cn/problems/predict-the-winner/

给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字
（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
提示：
1 <= nums.length <= 20
0 <= nums[i] <= 10^7

递归 / 动态规划
 */