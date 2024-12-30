import java.util.Arrays;

public class SolutionP1820 {
    static class V1{

    }
    private int[][] g;
    private int m, n, dfn;
    private int[] pa, pb, vis;

    public int maximumInvitations(int[][] grid) {
        this.g = grid;
        m = grid.length;
        n = grid[0].length;
        dfn = 0;
        pa = new int[m];
        Arrays.fill(pa, -1);
        pb = new int[n];
        Arrays.fill(pb, -1);
        vis = new int[m];

        int res = 0;
        while (true) {
            dfn++;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (pa[i] == -1 && dfs(i)) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                break;
            }
            res += cnt;
        }
        return res;
    }

    private boolean dfs(int x) {
        vis[x] = dfn;
        for (int y = 0; y < n; y++) {
            if (g[x][y] == 0) continue;
            if (pb[y] == -1) {
                pb[y] = x;
                pa[x] = y;
                return true;
            }
        }
        for (int y = 0; y < n; y++) {
            if (g[x][y] == 0) continue;
            if (vis[pb[y]] != dfn && dfs(pb[y])) {
                pa[x] = y;
                pb[y] = x;
                return true;
            }
        }
        return false;
    }
}
/*
$1820. 最多邀请的个数
https://leetcode.cn/problems/maximum-number-of-accepted-invitations/

某一个班级有 m 个男孩和 n 个女孩，即将举行一个派对。
给定一个 m x n 的整数矩阵 grid ，其中 grid[i][j] 等于 0 或 1 。 若 grid[i][j] == 1 ，则表示第 i 个男孩可以邀请第 j 个女孩参加派对。 一个男孩最多可以邀请一个女孩，一个女孩最多可以接受一个男孩的一个邀请。
返回可能的最多邀请的个数。
提示：
grid.length == m
grid[i].length == n
1 <= m, n <= 200
grid[i][j] 是 0 或 1 之一。

二分图最大匹配
增广路算法
时间复杂度 O(nm)
https://oi-wiki.org/graph/graph-matching/bigraph-match/
相似题目: $2123. 使矩阵中的 1 互不相邻的最小操作数
https://leetcode.cn/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/description/
 */