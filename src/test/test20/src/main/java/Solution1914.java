import java.util.ArrayList;
import java.util.List;

public class Solution1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int minMN = Math.min(m, n);
        int maxDeep = minMN / 2;
        for (int curDeep = 0; curDeep < maxDeep; curDeep++) {
            // 环到列表
            List<Integer> tmpList = gridToList(grid, curDeep);
            // 取模
            modList(tmpList, k);
            // 列表到环
            listToGrid(tmpList, curDeep, grid);
        }
        return grid;
    }

    private void modList(List<Integer> list, int k) {
        int size = list.size();
        k = k % size;
        for (int i = 0; i < k; i++) {
            Integer begin = list.remove(0);
            list.add(begin);
        }
    }

    private List<Integer> gridToList(int[][] grid, int deep) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        // right
        for (int i = deep; i < n - deep; i++) {
            list.add(grid[deep][i]);
        }
        // down
        for (int i = deep + 1; i < m - deep; i++) {
            list.add(grid[i][n - 1 - deep]);
        }
        // left
        for (int i = n - 2 - deep; i >= deep; i--) {
            list.add(grid[m - 1 - deep][i]);
        }
        // up
        for (int i = m - 2 - deep; i >= deep + 1; i--) {
            list.add(grid[i][deep]);
        }
        return list;
    }

    private void listToGrid(List<Integer> list, int deep, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // right
        for (int i = deep; i < n - deep; i++) {
            grid[deep][i] = list.remove(0);
        }
        // down
        for (int i = deep + 1; i < m - deep; i++) {
            grid[i][n - 1 - deep] = list.remove(0);
        }
        // left
        for (int i = n - 2 - deep; i >= deep; i--) {
            grid[m - 1 - deep][i] = list.remove(0);
        }
        // up
        for (int i = m - 2 - deep; i >= deep + 1; i--) {
            grid[i][deep] = list.remove(0);
        }
    }
}
/*
1914. 循环轮转矩阵
https://leetcode.cn/problems/cyclically-rotating-a-grid/

第 247 场周赛 T2。

给你一个大小为 m x n 的整数矩阵 grid ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
矩阵由若干层组成，如下图所示，每种颜色代表一层：
矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
返回执行 k 次循环轮转操作后的矩阵。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 50
m 和 n 都是 偶数
1 <= grid[i][j] <= 5000
1 <= k <= 10^9

没啥好的办法，逐层去模拟，将矩阵降维为数组模拟操作，操作完再将数组还原为矩阵。
注意推倒转换方法的时候，不要用正方形，容易出错，譬如可选用 8*4 矩阵。
 */