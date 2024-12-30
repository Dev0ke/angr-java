import java.util.List;

public class SolutionP1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int M = dimensions.get(0);
        int N = dimensions.get(1);

        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // FFFTTT
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left < N) {
                minIdx = Math.min(minIdx, left);
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }

    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    }
}
/*
$1428. 至少有一个 1 的最左端列
https://leetcode.cn/problems/leftmost-column-with-at-least-a-one/

（这是一个交互题）
我们称只包含元素 0 或 1 的矩阵为二进制矩阵。矩阵中每个单独的行都按非递减顺序排序。
给定一个这样的二进制矩阵，返回至少包含一个 1 的最左端列的索引（从 0 开始）。如果这样的列不存在，返回 -1。
您不能直接访问该二进制矩阵。你只可以通过 BinaryMatrix 接口来访问。
- BinaryMatrix.get(row, col) 返回位于索引 (row, col) （从 0 开始）的元素。
- BinaryMatrix.dimensions() 返回含有 2 个元素的列表 [rows, cols]，表示这是一个 rows * cols的矩阵。
如果提交的答案调用 BinaryMatrix.get 超过 1000 次，则该答案会被判定为错误答案。提交任何试图规避判定机制的答案将会被取消资格。
下列示例中， mat 为给定的二进制矩阵。您不能直接访问该矩阵。
提示:
rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] 只会是 0 或 1。
mat[i] 已按非递减顺序排序。

二分
 */