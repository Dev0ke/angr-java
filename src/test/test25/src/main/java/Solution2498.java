public class Solution2498 {
    public int maxJump(int[] stones) {
        int len = stones.length;
        int max = 0;
        if (len <= 2) {
            return stones[len - 1];
        }
        for (int i = 2; i < len; i += 2) {
            max = Math.max(max, stones[i] - stones[i - 2]);
        }
        for (int i = 3; i < len; i += 2) {
            max = Math.max(max, stones[i] - stones[i - 2]);
        }
        return max;
    }
}
/*
2498. 青蛙过河 II
https://leetcode.cn/problems/frog-jump-ii/

第 93 场双周赛 T3。

给你一个下标从 0开始的整数数组stones，数组中的元素严格递增，表示一条河中石头的位置。
一只青蛙一开始在第一块石头上，它想到达最后一块石头，然后回到第一块石头。同时每块石头 至多 到达 一次。
一次跳跃的 长度是青蛙跳跃前和跳跃后所在两块石头之间的距离。
- 更正式的，如果青蛙从stones[i]跳到stones[j]，跳跃的长度为|stones[i] - stones[j]|。
一条路径的 代价是这条路径里的最大跳跃长度。
请你返回这只青蛙的 最小代价。
提示：
2 <= stones.length <= 10^5
0 <= stones[i] <= 10^9
stones[0] == 0
stones 中的元素严格递增。

贪心。可以证明，间隔 2 去跳距离总是最下的。
 */