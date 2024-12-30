public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(m, n, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // FFFTTT
    private boolean checkMid(int m, int n, int k, int mid) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(mid / i, n);
        }
        return cnt >= k;
    }
}
/*
668. 乘法表中第k小的数
https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/

几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
注意：
m 和 n 的范围在 [1, 30000] 之间。
k 的范围在 [1, m * n] 之间。

二分
相似题目: 378. 有序矩阵中第 K 小的元素
https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */