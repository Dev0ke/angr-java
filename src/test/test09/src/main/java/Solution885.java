public class Solution885 {
    // 顺时针 右下左上
    private static final int[] DR = new int[]{0, 1, 0, -1};
    private static final int[] DC = new int[]{1, 0, -1, 0};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int id = 0;

        res[id++] = new int[]{rStart, cStart};
        if (id == rows * cols) {
            return res;
        }
        // 两个一组
        for (int k = 1; k < (rows + cols) * 2; k += 2) {
            // 四个方向
            for (int i = 0; i < 4; i++) {
                // 步长 1,1,2,2,3,3,4,4,···
                int step = k + (i / 2);
                for (int j = 0; j < step; j++) {
                    rStart += DR[i];
                    cStart += DC[i];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[id++] = new int[]{rStart, cStart};
                        if (id == rows * cols) {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
}
/*
885. 螺旋矩阵 III
https://leetcode.cn/problems/spiral-matrix-iii/

在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。
最终，我们到过网格的所有 rows x cols 个空间。
按照访问顺序返回表示网格位置的坐标列表。
提示：
1 <= rows, cols <= 100
0 <= rStart < rows
0 <= cStart < cols

模拟
相似题目: 54. 螺旋矩阵
https://leetcode.cn/problems/spiral-matrix/
59. 螺旋矩阵 II
https://leetcode.cn/problems/spiral-matrix-ii/
 */