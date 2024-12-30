import java.util.Arrays;

public class Solution3320 {
    private static final int MOD = (int) (1e9 + 7);
    private String s;
    private long[][][] memo;

    public int countWinningSequences(String s) {
        this.s = s;

        int n = s.length();
        memo = new long[n][4][n * 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) dfs(0, 3, n);
    }

    // j:Bob 选了啥
    private long dfs(int i, int j, int bob_score) {
        if (i == s.length()) {
            return bob_score > s.length() ? 1 : 0;
        }
        if (memo[i][j][bob_score] != -1) return memo[i][j][bob_score];
        long res = 0;
        for (int bob_ch = 0; bob_ch <= 2; bob_ch++) {
            if (bob_ch != j) { // 但保证 Bob 不会在连续两个回合中召唤相同的生物
                int alice_ch = getCharIdx(s.charAt(i));
                int comp = comp(alice_ch, bob_ch);
                res = (res + dfs(i + 1, bob_ch, bob_score + comp)) % MOD;
            }
        }
        return memo[i][j][bob_score] = res;
    }

    private int comp(int alice_ch, int bob_ch) {
        if (alice_ch == 0 && bob_ch == 2) return -1; // 如果一方召唤火龙而另一方召唤地精，召唤 火龙 的玩家将获得一分。
        if (alice_ch == 2 && bob_ch == 0) return 1;

        if (alice_ch == 1 && bob_ch == 0) return -1; // 如果一方召唤水蛇而另一方召唤火龙，召唤 水蛇 的玩家将获得一分。
        if (alice_ch == 0 && bob_ch == 1) return 1;

        if (alice_ch == 2 && bob_ch == 1) return -1; // 如果一方召唤地精而另一方召唤水蛇，召唤 地精 的玩家将获得一分。
        if (alice_ch == 1 && bob_ch == 2) return 1;
        return 0; // 如果双方召唤相同的生物，那么两个玩家都不会获得分数。
    }

    // F,W,E => 0,1,2
    private int getCharIdx(char ch) {
        if (ch == 'F') return 0;
        if (ch == 'W') return 1;
        return 2;
    }
}
/*
3320. 统计能获胜的出招序列数
https://leetcode.cn/problems/count-the-number-of-winning-sequences/description/

第 419 场周赛 T3。

Alice 和 Bob 正在玩一个幻想战斗游戏，游戏共有 n 回合，每回合双方各自都会召唤一个魔法生物：火龙（F）、水蛇（W）或地精（E）。每回合中，双方 同时 召唤魔法生物，并根据以下规则得分：
- 如果一方召唤火龙而另一方召唤地精，召唤 火龙 的玩家将获得一分。
- 如果一方召唤水蛇而另一方召唤火龙，召唤 水蛇 的玩家将获得一分。
- 如果一方召唤地精而另一方召唤水蛇，召唤 地精 的玩家将获得一分。
- 如果双方召唤相同的生物，那么两个玩家都不会获得分数。
给你一个字符串 s，包含 n 个字符 'F'、'W' 和 'E'，代表 Alice 每回合召唤的生物序列：
- 如果 s[i] == 'F'，Alice 召唤火龙。
- 如果 s[i] == 'W'，Alice 召唤水蛇。
- 如果 s[i] == 'E'，Alice 召唤地精。
Bob 的出招序列未知，但保证 Bob 不会在连续两个回合中召唤相同的生物。如果在 n 轮后 Bob 获得的总分 严格大于 Alice 的总分，则 Bob 战胜 Alice。
返回 Bob 可以用来战胜 Alice 的不同出招序列的数量。
由于答案可能非常大，请返回答案对 10^9 + 7 取余 后的结果。

记忆化搜索。
 */