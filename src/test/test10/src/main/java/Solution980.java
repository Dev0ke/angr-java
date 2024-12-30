import java.util.Arrays;

public class Solution980 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;
    private int tr;
    private int tc;
    private int[][][] memo;

    // 记忆化搜索 时间复杂度 O(MN*2^(MN))
    public int uniquePathsIII(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int target = 0;

        int sr = 0;
        int sc = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] % 2 == 0) {
                    target |= code(i, j);
                }

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                }
            }
        }

        memo = new int[M][N][1 << (M * N)];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dp(sr, sc, target);
    }

    private int code(int i, int j) {
        return 1 << (i * N + j);
    }

    private int dp(int i, int j, int todo) {
        if (memo[i][j][todo] != -1) {
            return memo[i][j][todo];
        }
        if (i == tr && j == tc) {
            return todo == 0 ? 1 : 0;
        }

        int res = 0;
        for (int[] dir : DIRECTIONS) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                if ((todo & code(nextM, nextN)) != 0) {
                    res += dp(nextM, nextN, todo ^ code(nextM, nextN));
                }
            }
        }
        memo[i][j][todo] = res;
        return res;
    }

    private int[][] grid;
    private int res;

    // DFS 时间复杂度 O(4^(MN))
    public int uniquePathsIII2(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;

        int todo = 0;
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != -1) {
                    todo++;
                }

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                }
            }
        }

        res = 0;
        dfs(sr, sc, todo);
        return res;
    }

    public void dfs(int i, int j, int todo) {
        todo--;
        if (todo < 0) {
            return;
        }
        if (i == tr && j == tc) {
            if (todo == 0) {
                res++;
            }
            return;
        }

        grid[i][j] = 3;
        for (int[] dir : DIRECTIONS) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                if (grid[nextM][nextN] % 2 == 0) {
                    dfs(nextM, nextN, todo);
                }
            }
        }
        grid[i][j] = 0;
    }
}
/*
980. 不同路径 III
https://leetcode.cn/problems/unique-paths-iii/

在二维网格 grid 上，有 4 种类型的方格：
- 1 表示起始方格。且只有一个起始方格。
- 2 表示结束方格，且只有一个结束方格。
- 0 表示我们可以走过的空方格。
- -1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
提示：
1 <= grid.length * grid[0].length <= 20

DFS / 动态规划
（好像跟 不同路径 系列题目没啥关系。。
 */