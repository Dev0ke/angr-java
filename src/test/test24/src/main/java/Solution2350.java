import java.util.Arrays;

public class Solution2350 {
    public int shortestSequence(int[] rolls, int k) {
        boolean[] visited = new boolean[k + 1];
        int res = 0;
        int cnt = 0;
        for (int roll : rolls) {
            if (!visited[roll]) {
                visited[roll] = true;
                cnt++;
                if (cnt == k) {
                    cnt = 0;
                    Arrays.fill(visited, false);
                    res++;
                }
            }
        }
        return res + 1;
    }
}
/*
2350. 不可能得到的最短骰子序列
https://leetcode.cn/problems/shortest-impossible-sequence-of-rolls/

第 83 场双周赛 T4。

给你一个长度为 n 的整数数组 rolls 和一个整数 k 。你扔一个 k 面的骰子 n 次，骰子的每个面分别是 1 到 k ，其中第 i 次扔得到的数字是 rolls[i] 。
请你返回 无法 从 rolls 中得到的 最短 骰子子序列的长度。
扔一个 k 面的骰子 len 次得到的是一个长度为 len 的 骰子子序列 。
注意 ，子序列只需要保持在原数组中的顺序，不需要连续。
提示：
n == rolls.length
1 <= n <= 10^5
1 <= rolls[i] <= k <= 10^5

贪心。考虑每轮最后一个数字，如果这个数字后能完整出现 1~k，则长度才能 +1。
比赛时满脑子都是 二分/全排列/LCS，但清晰知道时间复杂度 不能满足，因此只能坐牢。。
 */