public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 假设第 k 小的元素为 mid，大于等于 mid 的元素至少有 k 个，FFFTTT
    private boolean checkMid(int[][] matrix, int k, int mid) {
        // 左下角开始
        int curM = matrix.length - 1;
        int curN = 0;

        int cnt = 0;
        while (curM >= 0 && curN < matrix.length) {
            if (matrix[curM][curN] <= mid) {
                cnt += curM + 1;
                curN++;
            } else {
                curM--;
            }
        }
        return cnt >= k;
    }
}
/*
378. 有序矩阵中第 K 小的元素
https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/

给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
你必须找到一个内存复杂度优于 O(n2) 的解决方案。
提示：
n == matrix.length
n == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
1 <= k <= n^2
进阶：
你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。

二分
时间复杂度 O(nlog(r-l))
空间复杂度 O(1)
相似题目: 668. 乘法表中第k小的数
https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */