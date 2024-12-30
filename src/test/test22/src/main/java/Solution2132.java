public class Solution2132 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int M = grid.length;
        int N = grid[0].length;

        PrefixSum2d prefixSum2d = new PrefixSum2d(grid);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 每个格子要么为 0 （空）要么为 1 （被占据）。
                if (grid[i][j] == 0) {
                    int row2 = i + stampHeight - 1;
                    int col2 = j + stampWidth - 1;
                    // 可以贴邮票
                    if (row2 < M && col2 < N && prefixSum2d.sumRegion(i, j, row2, col2) == 0) {
                        prefixSum2d.rangeAdd(i, j, row2, col2, 1);
                    }
                }
            }
        }

        // 原数组
        int[][] originArr = prefixSum2d.originalArray();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 && originArr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class PrefixSum2d {
        private final int M;
        private final int N;
        private final int[][] preSum2d;
        private final int[][] diff2d;

        public PrefixSum2d(int[][] matrix) {
            this.M = matrix.length;
            this.N = matrix[0].length;
            // 预处理前缀和
            preSum2d = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    // 当前格 = 上 + 左 - 左上 + 原值
                    preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            // 差分 init
            diff2d = new int[M + 1][N + 1];
        }

        // 二维前缀和：求 matrix [row1,col1] 到 [row2,col2] 的累加和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
        }

        // 二维差分：matrix [row1,col1] 到 [row2,col2] 全部增加 inc
        public void rangeAdd(int row1, int col1, int row2, int col2, int inc) {
            diff2d[row1][col1] += inc;
            diff2d[row1][col2 + 1] -= inc;
            diff2d[row2 + 1][col1] -= inc;
            diff2d[row2 + 1][col2 + 1] += inc;
        }

        // 二维差分：获取原数组
        public int[][] originalArray() {
            int[][] res = new int[M][N];
            // 0 行
            res[0][0] = diff2d[0][0];
            for (int j = 1; j < N; j++) {
                res[0][j] = res[0][j - 1] + diff2d[0][j];
            }
            // 0 列
            for (int i = 1; i < M; i++) {
                res[i][0] = res[i - 1][0] + diff2d[i][0];
            }
            // 1 行 1 列。。。
            for (int i = 1; i < M; i++) {
                for (int j = 1; j < N; j++) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + diff2d[i][j];
                }
            }
            return res;
        }
    }
}
/*
2132. 用邮票贴满网格图
https://leetcode.cn/problems/stamping-the-grid/

第 69 场双周赛 T4。

给你一个 m x n 的二进制矩阵 grid ，每个格子要么为 0 （空）要么为 1 （被占据）。
给你邮票的尺寸为 stampHeight x stampWidth 。我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ：
1.覆盖所有 空 格子。
2.不覆盖任何 被占据 的格子。
3.我们可以放入任意数目的邮票。
4.邮票可以相互有 重叠 部分。
5.邮票不允许 旋转 。
6.邮票必须完全在矩阵 内 。
如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false 。
提示：
m == grid.length
n == grid[r].length
1 <= m, n <= 10^5
1 <= m * n <= 2 * 10^5
grid[r][c] 要么是 0 ，要么是 1 。
1 <= stampHeight, stampWidth <= 10^5

二维前缀和 + 二维差分
前缀和用于 O(1) 内检查区域内是否有被占据 的格子
差分用于模拟贴邮票，最后还原原数组。
时间复杂度 O(mn)
空间复杂度 O(mn)
相似题目: 304. 二维区域和检索 - 矩阵不可变
https://leetcode.cn/problems/range-sum-query-2d-immutable/
 */