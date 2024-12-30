import java.util.Arrays;

public class Solution1563 {
    private int[] stoneValue;
    private int[][] memo;

    // O(n^3)
    public int stoneGameV(int[] stoneValue) {
        this.stoneValue = stoneValue;
        int n = stoneValue.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1);
    }

    // Alice 面对数组 stoneValue 中从位置 l 到 r 这一段连续的石子时，她能获得的最大分数
    private int dfs(int l, int r) {
        if (l == r) return 0;
        if (memo[l][r] != -1) return memo[l][r];

        int sum = 0;
        for (int i = l; i <= r; ++i) {
            sum += stoneValue[i];
        }
        int res = 0;
        int sumL = 0;
        for (int i = l; i < r; ++i) {
            sumL += stoneValue[i];
            int sumR = sum - sumL;
            if (sumL < sumR) {
                res = Math.max(res, dfs(l, i) + sumL);
            } else if (sumL > sumR) {
                res = Math.max(res, dfs(i + 1, r) + sumR);
            } else {
                res = Math.max(res, Math.max(dfs(l, i), dfs(i + 1, r)) + sumL);
            }
        }
        return memo[l][r] = res;
    }
}
/*
1563. 石子游戏 V
https://leetcode.cn/problems/stone-game-v/description/

几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。
游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。
只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。
返回 Alice 能够获得的最大分数 。
提示：
1 <= stoneValue.length <= 500
1 <= stoneValue[i] <= 10^6

记忆化搜索。
有 O(n^2) 解法。
 */