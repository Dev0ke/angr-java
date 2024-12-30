import java.util.Arrays;

public class Solution1900 {
    private int[][][][] memo;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        memo = new int[n + 1][n][n][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return dfs(n, firstPlayer - 1, secondPlayer - 1); // 下标从 0 开始
    }

    // 人数为 n，两名选手位置分别在 fi 和 se 时的最早回合数和最晚回合数
    private int[] dfs(int n, int fi, int se) {
        if (fi + se == n - 1) { // 发生比拼
            return new int[]{1, 1};
        }
        if (fi >= n - fi - 1 || fi > n - se - 1) { // 为简化后续枚举过程，在枚举前处理一下两名选手的位置
            int fi0 = fi, se0 = se;
            fi = n - 1 - se0;
            se = n - 1 - fi0;
        }
        if (memo[n][fi][se][0] != -1) return memo[n][fi][se];
        int mid = (n + 1) / 2; // 下一轮人数
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        for (int i = 0; i <= fi; i++) { // 枚举第一名选手左侧保留多少个人
            for (int j = 0; j < Math.min(se, n - se - 1) - fi; j++) { // 枚举第一名选手和第二名选手中间保留多少个人
                int[] next;
                if (se < mid) { // 两人同侧（处理位置后都位于中间位置左侧）
                    next = dfs(mid, i, i + j + 1);
                } else { // 两人异侧
                    next = dfs(mid, i, (2 * se - n + 1) / 2 + i + j + 1);
                }
                ans[0] = Math.min(next[0], ans[0]);
                ans[1] = Math.max(next[1], ans[1]);
            }
        }
        // 加上当前回合数
        ans[0]++;
        ans[1]++;
        return memo[n][fi][se] = ans;
    }
}
/*
1900. 最佳运动员的比拼回合
https://leetcode.cn/problems/the-earliest-and-latest-rounds-where-players-compete/description/

n 名运动员参与一场锦标赛，所有运动员站成一排，并根据 最开始的 站位从 1 到 n 编号（运动员 1 是这一排中的第一个运动员，运动员 2 是第二个运动员，依此类推）。
锦标赛由多个回合组成（从回合 1 开始）。每一回合中，这一排从前往后数的第 i 名运动员需要与从后往前数的第 i 名运动员比拼，获胜者将会进入下一回合。如果当前回合中运动员数目为奇数，那么中间那位运动员将轮空晋级下一回合。
- 例如，当前回合中，运动员 1, 2, 4, 6, 7 站成一排
  - 运动员 1 需要和运动员 7 比拼
  - 运动员 2 需要和运动员 6 比拼
  - 运动员 4 轮空晋级下一回合
每回合结束后，获胜者将会基于最开始分配给他们的原始顺序（升序）重新排成一排。
编号为 firstPlayer 和 secondPlayer 的运动员是本场锦标赛中的最佳运动员。在他们开始比拼之前，完全可以战胜任何其他运动员。而任意两个其他运动员进行比拼时，其中任意一个都有获胜的可能，因此你可以 裁定 谁是这一回合的获胜者。
给你三个整数 n、firstPlayer 和 secondPlayer 。返回一个由两个值组成的整数数组，分别表示两位最佳运动员在本场锦标赛中比拼的 最早 回合数和 最晚 回合数。
提示：
2 <= n <= 28
1 <= firstPlayer < secondPlayer <= n

枚举下一轮两名选手的位置。
https://leetcode.cn/problems/the-earliest-and-latest-rounds-where-players-compete/solutions/825860/dpmei-ju-xia-yi-lun-liang-ming-xuan-shou-okfu
 */