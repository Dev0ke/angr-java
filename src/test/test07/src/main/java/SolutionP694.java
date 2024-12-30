import java.util.HashSet;
import java.util.Set;

public class SolutionP694 {
    private int M;
    private int N;

    public int numDistinctIslands(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        Set<String> pathSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, 0, path);
                    pathSet.add(path.toString());
                }
            }
        }
        return pathSet.size();
    }

    // direction = [0,1,2,3,4]
    private void dfs(int[][] grid, int i, int j, int direction, StringBuilder path) {
        if (i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == 1) {
            grid[i][j] = 0;
            path.append(direction);
            dfs(grid, i + 1, j, 1, path);
            dfs(grid, i, j + 1, 2, path);
            dfs(grid, i - 1, j, 3, path);
            dfs(grid, i, j - 1, 4, path);
            path.append(",");
        }
    }
}
/*
$694. 不同岛屿的数量
https://leetcode.cn/problems/number-of-distinct-islands/

给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
注意：
11
1
和
 1
11
是不同的岛屿，因为我们不考虑旋转、翻转操作。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 仅包含 0 或 1

形状相同等价与 dfs 顺序相同，因此 dfs 每个岛屿的时候记录 path，最后去重后求数量即可。
 */