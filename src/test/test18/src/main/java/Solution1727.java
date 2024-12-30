import java.util.Arrays;

public class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] cntArr = new int[m][n];
        // 处理第 0 行
        System.arraycopy(matrix[0], 0, cntArr[0], 0, n);
        // 第 1 ~ m-1 行
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    cntArr[i][j] = cntArr[i - 1][j] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            reverseSort(cntArr[i]);
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, cntArr[i][j] * (j + 1));
            }
        }
        return ans;
    }

    // 由大到小排序
    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
1727. 重新排列后的最大子矩阵
https://leetcode.cn/problems/largest-submatrix-with-rearrangements/

给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
提示：
m == matrix.length
n == matrix[i].length
1 <= m * n <= 10^5
matrix[i][j] 要么是 0 ，要么是 1 。

预处理每个位置向上连续 1 的数量。贪心求最大面积。
时间复杂度 O(mnlogn)
 */