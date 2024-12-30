public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;

        // 能到达的最远距离下标，当前下标，步数
        int maxR = 0, curR = 0, step = 0;
        // [1, n-1) 到达 nums[n - 1] 的最小跳跃次数
        for (int i = 0; i < n - 1; i++) {
            maxR = Math.max(maxR, i + nums[i]);
            if (i == curR) {
                curR = maxR;
                step++;
            }
        }
        return step;
    }
}
/*
45. 跳跃游戏 II
https://leetcode.cn/problems/jump-game-ii/

给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。
提示:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000

贪心。
相似题目: 1024. 视频拼接
https://leetcode.cn/problems/video-stitching/
1326. 灌溉花园的最少水龙头数目
https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */