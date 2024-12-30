import java.util.Arrays;

public class Solution3332 {
    private int n, k;
    private int[][] stayScore, travelScore;
    private int[][] memo;

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        this.n = n;
        this.k = k;
        this.stayScore = stayScore;
        this.travelScore = travelScore;

        memo = new int[k][n];
        for (int i = 0; i < k; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dfs(0, j));
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (i == k) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = dfs(i + 1, j) + stayScore[i][j];
        for (int nj = 0; nj < n; nj++) {
            res = Math.max(res, dfs(i + 1, nj) + travelScore[j][nj]); // travelScore[i][i] == 0
        }
        return memo[i][j] = res;
    }
}
/*
3332. 旅客可以得到的最多点数
https://leetcode.cn/problems/maximum-points-tourist-can-earn/description/

第 142 场双周赛 T3。

给你两个整数 n 和 k ，和两个二维整数数组 stayScore 和 travelScore 。
一位旅客正在一个有 n 座城市的国家旅游，每座城市都 直接 与其他所有城市相连。这位游客会旅游 恰好 k 天（下标从 0 开始），且旅客可以选择 任意 城市作为起点。
每一天，这位旅客都有两个选择：
- 留在当前城市：如果旅客在第 i 天停留在前一天所在的城市 curr ，旅客会获得 stayScore[i][curr] 点数。
- 前往另外一座城市：如果旅客从城市 curr 前往城市 dest ，旅客会获得 travelScore[curr][dest] 点数。
请你返回这位旅客可以获得的 最多 点数。
提示：
1 <= n <= 200
1 <= k <= 200
n == travelScore.length == travelScore[i].length == stayScore[i].length
k == stayScore.length
1 <= stayScore[i][j] <= 100
0 <= travelScore[i][j] <= 100
travelScore[i][i] == 0

记忆化搜索。
时间复杂度 O(k * n^2)。
 */