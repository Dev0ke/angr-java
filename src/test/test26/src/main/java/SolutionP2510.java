public class SolutionP2510 {
    static final int N = 105;
    static int[][] mi = new int[N][N];
    static int[][] ma = new int[N][N];

    public boolean isThereAPath(int[][] grid) {
        int n = grid.length, m = grid[0].length, t = (n + m - 1) / 2;
        if ((n + m - 1) % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mi[i][j] = Integer.MAX_VALUE;
                ma[i][j] = Integer.MIN_VALUE;
            }
        }
        mi[0][0] = ma[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = grid[i][j];
                if (i >= 1) {
                    upd_mi(mi, i, j, mi[i - 1][j] + x);
                    upd_ma(ma, i, j, ma[i - 1][j] + x);
                }
                if (j >= 1) {
                    upd_mi(mi, i, j, mi[i][j - 1] + x);
                    upd_ma(ma, i, j, ma[i][j - 1] + x);
                }
            }
        }
        return mi[n - 1][m - 1] <= t && ma[n - 1][m - 1] >= t;
    }

    private void upd_mi(int[][] x, int i, int j, int val) {
        if (val < x[i][j]) x[i][j] = val;
    }

    private void upd_ma(int[][] x, int i, int j, int val) {
        if (val > x[i][j]) x[i][j] = val;
    }
}
/*
$2510. 检查是否有路径经过相同数量的 0 和 1
https://leetcode.cn/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s/description/

给定一个 下标从 0 开始 的 m x n 的 二进制 矩阵 grid ，从坐标为 (row, col) 的元素可以向右走 (row, col+1) 或向下走 (row+1, col) 。
返回一个布尔值，表示从 (0, 0) 出发是否存在一条路径，经过 相同 数量的 0 和 1，到达终点 (m-1, n-1) 。如果存在这样的路径返回 true ，否则返回 false 。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 100
grid[i][j] 不是 0 就是 1 。

https://leetcode.cn/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s/solutions/
首先注意到所有合法路径的长度均为 n+m−1，那么需要恰好经过 (n+m−1)/2 个 1。接下来利用以下引理：
引理. 将所有合法路径中经过 1 的最小(最大)次数记为 mi (ma)，则对于所有 mi ~ ma 之间的整数 t，均存在经过恰好 t 个 1 的合法路径。
证明. 以下方法可以把一条合法路径连续地变成另一条，并保证所有中间状态仍然是合法路径。先找到起始和目标路径的第一个分岔点，沿其中一条路径 P 向下走，
直到走到该路径向右的拐点，记为 (i,j) (左上角坐标记为 (0,0))。将其向内翻折，即从该路径中去掉 (i,j)，增加它右上角的点 (i−1,j+1)。得到的新路径 P′
仍然是合法的，经过 1 的次数与 P 相差不超过 1，且不断重复这一过程最终可得到目标路径。
那么只需用 DP 求出所有合法路径中经过 1 的最小及最大次数即可。复杂度 O(nm)。
 */