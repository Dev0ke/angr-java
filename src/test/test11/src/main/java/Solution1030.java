import java.util.Arrays;

public class Solution1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][2];
        int id = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[id++] = new int[]{i, j};
            }
        }

        Arrays.sort(ans, (o1, o2) -> {
            int d1 = Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter);
            int d2 = Math.abs(o2[0] - rCenter) + Math.abs(o2[1] - cCenter);
            return Integer.compare(d1, d2);
        });
        return ans;
    }
}
/*
1030. 距离顺序排列矩阵单元格
https://leetcode.cn/problems/matrix-cells-in-distance-order/description/

给定四个整数 rows, cols, rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
提示：
1 <= rows, cols <= 100
0 <= rCenter < rows
0 <= cCenter < cols

模拟。
时间复杂度 O(rows*cols * log(rows*cols))。
 */