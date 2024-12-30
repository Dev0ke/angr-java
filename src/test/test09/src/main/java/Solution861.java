public class Solution861 {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // step1 如果某行的第一位不是 1，进行翻转
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        // step2 在每行第一位都是 1 的前提下，逐列比较，如果某列 0 的个数大于 1 的个数，进行翻转
        for (int j = 1; j < n; j++) {
            int cnt0 = 0;
            for (int[] row : grid) {
                if (row[j] == 0) {
                    cnt0++;
                }
            }
            int cnt1 = m - cnt0;
            if (cnt0 > cnt1) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        // step3 二进制相加
        int ans = 0;
        for (int[] row : grid) {
            int val = 0;
            for (int j = 0; j < n; j++) {
                val = val << 1 | row[j];
            }
            ans += val;
        }
        return ans;
    }
}
/*
861. 翻转矩阵后的得分
https://leetcode.cn/problems/score-after-flipping-matrix/

第 91 场周赛 T3。

给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。
一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。
在执行任意次 移动 后（含 0 次），返回可能的最高分数。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] 为 0 或 1

贪心，
最高位的 1 权重最高，如 1000=8 > 0111=7，需要确保最高位都为 1，
其次，其余位 1 的个数要尽可能多。
 */