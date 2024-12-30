public class Solution1439 {
    private int[][] mat;
    private int k;
    private int M;
    private int N;
    private int cnt = 0;

    public int kthSmallest(int[][] mat, int k) {
        this.mat = mat;
        this.k = k;
        this.M = mat.length;
        this.N = mat[0].length;

        // 最小和/最大和
        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < M; i++) {
            minSum += mat[i][0];
            maxSum += mat[i][N - 1];
        }

        // 二分 找 第 k 个最小数组和
        int left = minSum;
        int right = maxSum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            cnt = 1;
            dfs(0, minSum, mid);
            // FFFTTT
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // dfs 统计数组和小于等于 mid 的数量 cnt
    private void dfs(int i, int sum, int mid) {
        if (i < M && cnt < k) {
            // 不交换
            dfs(i + 1, sum, mid);
            // 交换
            for (int j = 1; j < N; j++) {
                int newSum = sum - mat[i][0] + mat[i][j];
                if (newSum > mid) {
                    break;
                }
                cnt++;
                dfs(i + 1, newSum, mid);
            }
        }
    }
}
/*
1439. 有序矩阵中的第 k 个最小数组和
https://leetcode.cn/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
提示：
m == mat.length
n == mat.length[i]
1 <= m, n <= 40
1 <= k <= min(200, n ^ m)
1 <= mat[i][j] <= 5000
mat[i] 是一个非递减数组

二分 + dfs
 */