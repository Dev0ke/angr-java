import java.util.Arrays;

public class Solution1690 {
    private int[] ps;
    private int[][] memo;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] += ps[i] + stones[i];
        }

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res1 = ps[j + 1] - ps[i + 1] - dfs(i + 1, j);
        int res2 = ps[j] - ps[i] - dfs(i, j - 1);
        return memo[i][j] = Math.max(res1, res2);
    }
}
/*
1690. 石子游戏 VII
https://leetcode.cn/problems/stone-game-vii/description/

石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
提示：
n == stones.length
2 <= n <= 1000
1 <= stones[i] <= 1000

记忆化搜索。
子问题，都是最大化「先手」的得分减去「后手」的得分，都是和原问题相似的、规模更小的子问题，所以可以用递归解决。
时间复杂度 O(n^2)。
 */