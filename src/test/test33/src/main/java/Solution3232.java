public class Solution3232 {
    public boolean canAliceWin(int[] nums) {
        // 个数数，两位数 之和
        int sum1 = 0, sum2 = 0;
        for (int v : nums) {
            if (v < 10) sum1 += v;
            else sum2 += v;
        }
        return sum1 != sum2;
    }
}
/*
3232. 判断是否可以赢得数字游戏
https://leetcode.cn/problems/find-if-digit-game-can-be-won/description/

第 408 场周赛 T1。

给你一个 正整数 数组 nums。
Alice 和 Bob 正在玩游戏。在游戏中，Alice 可以从 nums 中选择所有个位数 或 所有两位数，剩余的数字归 Bob 所有。如果 Alice 所选数字之和 严格大于 Bob 的数字之和，则 Alice 获胜。
如果 Alice 能赢得这场游戏，返回 true；否则，返回 false。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 99

两题选手。
模拟。
时间复杂度 O(n)。
 */