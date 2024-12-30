public class Solution2139 {
    public int minMoves(int target, int maxDoubles) {
        int cnt = 0;
        while (target > 1) {
            if (maxDoubles > 0) {
                if (target % 2 == 0) {
                    maxDoubles--;
                    target /= 2;
                } else {
                    target -= 1;
                }
                cnt++;
            } else {
                int diff = target - 1;
                target -= diff;
                cnt += diff;
            }
        }
        return cnt;
    }
}
/*
2139. 得到目标值的最少行动次数
https://leetcode.cn/problems/minimum-moves-to-reach-target-score/

第 276 场周赛 T2。

你正在玩一个整数游戏。从整数 1 开始，期望得到整数 target 。
在一次行动中，你可以做下述两种操作之一：
- 递增，将当前整数的值加 1（即， x = x + 1）。
- 加倍，使当前整数的值翻倍（即，x = 2 * x）。
在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 maxDoubles 次。
给你两个整数 target 和 maxDoubles ，返回从 1 开始得到 target 需要的最少行动次数。
提示：
1 <= target <= 10^9
0 <= maxDoubles <= 100

贪心。因为从从整数 1 开始，除了 1+1 == 2*1 外，其余 加倍 的效率均高于 递增。因此加倍的机会要挪到后面才操作。
从 target 反推到 1 即可，需注意 target <= 10^9，模拟递减 TLE 情况。
 */