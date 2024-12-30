public class Solution2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] res = new int[2];
        for (int i = 0; i < m; i++) {
            int cnt1 = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt1++;
                }
            }
            if (res[1] < cnt1) {
                res[0] = i;
                res[1] = cnt1;
            }
        }
        return res;
    }
}
/*
2643. 一最多的行
https://leetcode.cn/problems/row-with-maximum-ones/

第 341 场周赛 T1。

给你一个大小为 m x n 的二进制矩阵 mat ，请你找出包含最多 1 的行的下标（从 0 开始）以及这一行中 1 的数目。
如果有多行包含最多的 1 ，只需要选择 行下标最小 的那一行。
返回一个由行下标和该行中 1 的数量组成的数组。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] 为 0 或 1

模拟。
 */