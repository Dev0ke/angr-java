import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution827 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int n;
    private int[][] grid;
    private int[][] tag;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        this.grid = grid;

        int ans = 0;
        tag = new int[n][n];
        Map<Integer, Integer> areaMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1;
                    int area = getArea(i, j, t);
                    areaMap.put(t, area);
                    ans = Math.max(ans, area);
                }
            }
        }

        // 枚举每个 grid[i][j] == 0 点变为岛屿
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int z = 1;
                Set<Integer> connected = new HashSet<>();
                for (int[] d : DIRECTIONS) {
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n
                            && tag[nx][ny] != 0 && !connected.contains(tag[nx][ny])) {
                        int t = tag[nx][ny];
                        z += areaMap.get(t);
                        connected.add(t);
                    }
                }
                ans = Math.max(ans, z);
            }
        }
        return ans;
    }

    // dfs 求岛屿面积
    private int getArea(int x, int y, int t) {
        int area = 1;
        tag[x][y] = t;
        for (int[] d : DIRECTIONS) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                    && grid[nx][ny] == 1 && tag[nx][ny] == 0) {
                area += getArea(nx, ny, t);
            }
        }
        return area;
    }
}
/*
827. 最大人工岛
https://leetcode.cn/problems/making-a-large-island/description/

给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
返回执行此操作后，grid 中最大的岛屿面积是多少？
岛屿 由一组上、下、左、右四个方向相连的 1 形成。
提示：
n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] 为 0 或 1

1、dfs 求岛屿面积
2、枚举每个 grid[i][j] == 0 点变为岛屿
时间复杂度 O(n^2)。
 */