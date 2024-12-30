import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3276 {
    private List<Integer>[] posMap;
    private int[][] memo;

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int mx = 100;

        posMap = new ArrayList[mx + 1];
        Arrays.setAll(posMap, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid.get(i).get(j);
                posMap[v].add(i);
            }
        }

        memo = new int[mx + 1][1 << m];
        for (int i = 0; i < mx + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(mx, 0);
    }

    // i：可选 [0,i-1] 的数，j：二进制，已选的行数
    private int dfs(int i, int j) {
        if (i == 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = dfs(i - 1, j);
        for (Integer k : posMap[i]) {
            if ((j >> k & 1) == 0) { // 可以在第 k 行选
                res = Math.max(res, dfs(i - 1, j | (1 << k)) + i);
            }
        }
        return memo[i][j] = res;
    }
}
/*
3276. 选择矩阵中单元格的最大得分
https://leetcode.cn/problems/select-cells-in-grid-with-maximum-score/description/

第 413 场周赛 T3。

给你一个由正整数构成的二维矩阵 grid。
你需要从矩阵中选择 一个或多个 单元格，选中的单元格应满足以下条件：
- 所选单元格中的任意两个单元格都不会处于矩阵的 同一行。
- 所选单元格的值 互不相同。
你的得分为所选单元格值的总和。
返回你能获得的 最大 得分。
提示：
1 <= grid.length, grid[i].length <= 10
1 <= grid[i][j] <= 100

记忆化搜索。枚举值域，看每个数在每一行中 选或不选。
时间复杂度 O(mn * 2^m)。
本题也可以用费用流建模解决。
rating 2420 (clist.by)
 */