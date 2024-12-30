import java.util.HashMap;
import java.util.Map;

public class Solution3242 {
    static class neighborSum {
        int[][] grid;
        int n;
        Map<Integer, int[]> val2xy;
        private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

        public neighborSum(int[][] grid) {
            this.grid = grid;
            this.n = grid.length;
            val2xy = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    val2xy.put(grid[i][j], new int[]{i, j});
                }
            }
        }

        public int adjacentSum(int value) {
            return getAns(value, 0, 4);
        }

        public int diagonalSum(int value) {
            return getAns(value, 4, 8);
        }

        private int getAns(int value, int st, int end) {
            int res = 0;
            int[] p = val2xy.get(value);
            for (int i = st; i < end; i++) {
                int nx = p[0] + DIRECTIONS8[i][0];
                int ny = p[1] + DIRECTIONS8[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    res += grid[nx][ny];
                }
            }
            return res;
        }
    }
}
/*
3242. 设计相邻元素求和服务
https://leetcode.cn/problems/design-neighbor-sum-service/description/

给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
实现 neighborSum 类：
- neighborSum(int [][]grid) 初始化对象。
- int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
- int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
提示：
3 <= n == grid.length == grid[0].length <= 10
0 <= grid[i][j] <= n^2 - 1
所有 grid[i][j] 值均不重复。
adjacentSum 和 diagonalSum 中的 value 均在范围 [0, n^2 - 1] 内。
最多会调用 adjacentSum 和 diagonalSum 总共 2 * n^2 次。

模拟。最近比较复杂的 T1 了。
 */