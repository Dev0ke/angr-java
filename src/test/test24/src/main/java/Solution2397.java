public class Solution2397 {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;

        // 预处理 int[] => state 将一行映射成一个整数
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mask[i] |= (1 << j);
                }
            }
        }

        // 选取 cols 列
        int max = 0;
        for (int state = 0; state < (1 << n); state++) {
            if (Integer.bitCount(state) != cols) {
                continue;
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                // mask[i] 是否是 state 的一个子集
                if ((mask[i] & state) == mask[i]) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int maximumRows2(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;

        // 预处理 int[] => state 将一行映射成一个整数
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mask[i] |= (1 << j);
                }
            }
        }

        // Gosper's Hack 时间复杂度 O(1) 找到下一个大小为 cols 的集合
        int state = (1 << cols) - 1;
        int max = 0;
        while (state < (1 << n)) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                // mask[i] 是否是 state 的一个子集
                if ((mask[i] & state) == mask[i]) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);

            // Gosper's Hack
            int lowbit = state & (-state);
            int x = state + lowbit;
            state = (state ^ x) / lowbit >> 2 | x;
        }
        return max;
    }
}
/*
2397. 被列覆盖的最多行数
https://leetcode.cn/problems/maximum-rows-covered-by-columns/

第 86 场双周赛 T3。

给你一个下标从 0 开始的 m x n 二进制矩阵 mat 和一个整数 cols ，表示你需要选出的列数。
如果一行中，所有的 1 都被你选中的列所覆盖，那么我们称这一行 被覆盖 了。
请你返回在选择 cols 列的情况下，被覆盖 的行数 最大 为多少。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 12
mat[i][j] 要么是 0 要么是 1 。
1 <= cols <= n

状态压缩枚举
时间复杂度 O(C(n, k))。本题理论上界为 12! / 6! / 6! = 479,001,600 / 720 / 720 = 924。（朴素状态压缩枚举理论上界为 2^n = 2^12 = 4096）。
空间复杂度 O(m)
灵神直播介绍的黑科技 Gosper's Hack 时间复杂度 O(1) 找到下一个大小为 cols 的集合
 */