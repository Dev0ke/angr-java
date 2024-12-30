import java.util.Arrays;

public class Solution2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = m - 1;
        while (left <= right && up <= down) {
            // 左到右
            for (int j = left; j <= right; j++) {
                matrix[up][j] = head.val;
                head = head.next;
                if (head == null) {
                    return matrix;
                }
            }
            // 上到下
            for (int i = up + 1; i <= down; i++) {
                matrix[i][right] = head.val;
                head = head.next;
                if (head == null) {
                    return matrix;
                }
            }
            if (left < right && up < down) {
                // 右到左
                for (int j = right - 1; j > left; j--) {
                    matrix[down][j] = head.val;
                    head = head.next;
                    if (head == null) {
                        return matrix;
                    }
                }
                // 下到上
                for (int i = down; i > up; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                    if (head == null) {
                        return matrix;
                    }
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return matrix;
    }
}
/*
2326. 螺旋矩阵 IV
https://leetcode.cn/problems/spiral-matrix-iv/

第 300 场周赛 T2。

给你两个整数：m 和 n ，表示矩阵的维数。
另给你一个整数链表的头节点 head 。
请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
返回生成的矩阵。
提示：
1 <= m, n <= 10^5
1 <= m * n <= 10^5
链表中节点数目在范围 [1, m * n] 内
0 <= Node.val <= 1000

模拟。
相似题目: 59. 螺旋矩阵 II
https://leetcode.cn/problems/spiral-matrix-ii/
 */