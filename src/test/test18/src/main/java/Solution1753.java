import java.util.Arrays;

public class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        int sum = Arrays.stream(arr).sum();
        int mx = Arrays.stream(arr).max().orElseThrow();
        return Math.min(sum - mx, sum / 2);
    }
}
/*
1753. 移除石子的最大得分
https://leetcode.cn/problems/maximum-score-from-removing-stones/description/

你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。
每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
提示：
1 <= a, b, c <= 10^5

贪心。
时间复杂度 O(1)。
 */