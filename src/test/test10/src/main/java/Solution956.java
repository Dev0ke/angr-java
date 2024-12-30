import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution956 {
    // 29ms 时间复杂度 O(nS)
    private static final int INF = (int) 1e9;
    private static final int S = (int) 5e3;
    private int n;
    private int[] rods;
    private int[][] memo;

    public int tallestBillboard(int[] rods) {
        n = rods.length;
        this.rods = rods;
        memo = new int[n][S + S + 5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, S);
    }

    private int dfs(int i, int s) {
        if (i == n) {
            return s == S ? 0 : -INF;
        }
        if (memo[i][s] != -1) return memo[i][s];
        int res1 = dfs(i + 1, s);
        int res2 = dfs(i + 1, s - rods[i]);
        int res3 = rods[i] + dfs(i + 1, s + rods[i]);
        int res = Math.max(res1, Math.max(res2, res3));
        return memo[i][s] = res;
    }

    // 403ms
    // 折半搜索 时间复杂度 O(3^(n/2))
    static class V2 {
        private static final int MAX_N = (int) 6e4; // 3^10 = 59,049
        private int[] rods;

        public int tallestBillboard(int[] rods) {
            int n = rods.length;
            this.rods = rods;
            Map<Integer, Integer> L = meet_in_the_middle(0, n / 2);
            Map<Integer, Integer> R = meet_in_the_middle(n / 2, n);
            int ans = 0;
            for (int d : L.keySet()) {
                if (R.containsKey(-d)) {
                    ans = Math.max(ans, L.get(d) + R.get(-d));
                }
            }
            return ans;
        }

        private Map<Integer, Integer> meet_in_the_middle(int st, int end) {
            int[][] dp = new int[MAX_N][2];
            int t = 0;
            dp[t++] = new int[]{0, 0};
            for (int i = st; i < end; i++) {
                int v = rods[i];
                int stop = t;
                for (int j = 0; j < stop; j++) {
                    int[] p = dp[j];
                    dp[t++] = new int[]{p[0] + v, p[1]};
                    dp[t++] = new int[]{p[0], p[1] + v};
                }
            }

            Map<Integer, Integer> ans = new HashMap<>();
            for (int i = 0; i < t; i++) {
                int a = dp[i][0], b = dp[i][1];
                ans.merge(a - b, a, Math::max);
            }
            return ans;
        }
    }

}
/*
956. 最高的广告牌
https://leetcode.cn/problems/tallest-billboard/description/

你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
返回 广告牌的最大可能安装高度 。如果没法安装广告牌，请返回 0 。
提示：
0 <= rods.length <= 20
1 <= rods[i] <= 1000
sum(rods[i]) <= 5000

记忆化搜索 / 折半搜索。
时间复杂度 O(nS) / 时间复杂度 O(3^(n/2))
相似题目: $2143. 在两个数组的区间中选取数字
https://leetcode.cn/problems/choose-numbers-from-two-arrays-in-range/description/
 */