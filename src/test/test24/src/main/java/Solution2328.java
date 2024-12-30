public class Solution2328 {
    private static final long MOD = 1000000007;
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;
    private long[][] paths;

    public int countPaths(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        paths = new long[M][N];
        long sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum += dfs(grid, i, j);
                sum %= MOD;
            }
        }
        return (int) sum;
    }

    private long dfs(int[][] matrix, int i, int j) {
        if (paths[i][j] != 0) {
            return paths[i][j];
        }
        long cnt = 1;
        for (int[] dir : DIRECTIONS) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && matrix[nextM][nextN] > matrix[i][j]) {
                cnt += dfs(matrix, nextM, nextN);
                cnt %= MOD;
            }
        }
        paths[i][j] = cnt;
        return cnt;
    }
}
/*
2328. 网格图中递增路径的数目
https://leetcode.cn/problems/number-of-increasing-paths-in-a-grid/

第 300 场周赛 T4。

给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。
请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 10^9 + 7 取余 后返回。
如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
1 <= grid[i][j] <= 10^5

记忆化搜索
时间复杂度 O(mn)
相似题目: 329. 矩阵中的最长递增路径
https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 */