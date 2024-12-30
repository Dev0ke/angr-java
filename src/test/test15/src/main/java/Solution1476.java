import java.util.ArrayList;
import java.util.List;

public class Solution1476 {
    // 24ms
    static class SubrectangleQueries {
        int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }

    // 21ms
    static class SubrectangleQueries2 {
        int[][] rectangle;
        List<int[]> history;

        public SubrectangleQueries2(int[][] rectangle) {
            this.rectangle = rectangle;
            history = new ArrayList<>();
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            history.add(new int[]{row1, col1, row2, col2, newValue});
        }

        public int getValue(int row, int col) {
            for (int i = history.size() - 1; i >= 0; i--) {
                int[] hi = history.get(i);
                int r1 = hi[0], c1 = hi[1], r2 = hi[2], c2 = hi[3], newVal = hi[4];
                if (r1 <= row && row <= r2 && c1 <= col && col <= c2) {
                    return newVal;
                }
            }
            return rectangle[row][col];
        }
    }
}
/*
1476. 子矩形查询
https://leetcode.cn/problems/subrectangle-queries/description/

请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
- 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
2. getValue(int row, int col)
- 返回矩形中坐标 (row,col) 的当前值。
提示：
最多有 500 次updateSubrectangle 和 getValue 操作。
1 <= rows, cols <= 100
rows == rectangle.length
cols == rectangle[i].length
0 <= row1 <= row2 < rows
0 <= col1 <= col2 < cols
1 <= newValue, rectangle[i][j] <= 10^9
0 <= row < rows
0 <= col < cols

版本数组。可以做到和矩阵的大小无关。不过看执行用时跟暴力差不多。可能是用例的数组不够大。
矩形中所有元素覆盖为同一个值：使用版本数组
矩阵中所有元素增加同一个值：使用差分数组
单个元素修改区间查询：使用树状数组。
 */