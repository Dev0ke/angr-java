import java.util.Arrays;

public class Solution1575 {
    private static final int MOD = (int) (1e9 + 7);
    private int[] locations;
    private int finish;
    private int n;
    private int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        this.finish = finish;
        n = locations.length;

        memo = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(start, fuel);
    }

    public int dfs(int pos, int fuel) {
        if (Math.abs(locations[pos] - locations[finish]) > fuel) {
            return 0;
        }
        if (memo[pos][fuel] != -1) {
            return memo[pos][fuel];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (pos != i) {
                int cost = Math.abs(locations[pos] - locations[i]);
                if (cost <= fuel) {
                    res = (res + dfs(i, fuel - cost)) % MOD;
                }
            }
        }
        if (pos == finish) {
            res = (res + 1) % MOD;
        }
        memo[pos][fuel] = res;
        return res;
    }
}
/*
1575. 统计所有可行路径
https://leetcode.cn/problems/count-all-possible-routes/

给你一个 互不相同的整数数组，其中locations[i]表示第i个城市的位置。同时给你start，finish和fuel分别表示出发城市、目的地城市和你初始拥有的汽油总量
每一步中，如果你在城市 i，你可以选择任意一个城市 j，满足 j != i且0 <= j < locations.length，并移动到城市j。
从城市i移动到j消耗的汽油量为|locations[i] - locations[j]|，|x|表示x的绝对值。
请注意，fuel任何时刻都不能为负，且你可以经过任意城市超过一次（包括start和finish）。
请你返回从start到finish所有可能路径的数目。
由于答案可能很大， 请将它对10^9 + 7取余后返回。
提示：
2 <= locations.length <= 100
1 <= locations[i] <= 10^9
所有locations中的整数 互不相同。
0 <= start, finish <locations.length
1 <= fuel <= 200

记忆化搜索
 */