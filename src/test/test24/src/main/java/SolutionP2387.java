public class SolutionP2387 {
    public int matrixMedian(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = m * n / 2 + 1;

        int left = 1;
        int right = (int) (1e6 + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(grid, num, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[][] grid, int median, int x) {
        int ss = 0;
        for (int[] g : grid) {
            ss += bisect_left(g, x);
        }
        return ss >= median;
    }

    private int bisect_left(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
$2387. 行排序矩阵的中位数
https://leetcode.cn/problems/median-of-a-row-wise-sorted-matrix/description/

给定一个包含 奇数 个整数的 m x n 矩阵 grid，其中每一行按 非递减 的顺序排序，返回矩阵的 中位数。
你必须以 O(m * log(n)) 的时间复杂度来解决这个问题。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
m 和 n 都是奇数。
1 <= grid[i][j] <= 10^6
grid[i] 按非递减顺序排序

二分答案。
时间复杂度 O(m * logn * logmax)。
 */