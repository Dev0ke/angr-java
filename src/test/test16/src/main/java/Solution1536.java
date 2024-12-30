public class Solution1536 {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        // 每行最后一个 1 出现位置
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int k = -1;
            for (int j = i; j < n; j++) {
                if (pos[j] <= i) {
                    res += j - i;
                    k = j;
                    break;
                }
            }
            if (k >= 0) {
                for (int j = k; j > i; j--) {
                    int tmp = pos[j];
                    pos[j] = pos[j - 1];
                    pos[j - 1] = tmp;
                }
            } else {
                return -1;
            }
        }
        return res;
    }
}
/*
1536. 排布二进制网格的最少交换次数
https://leetcode.cn/problems/minimum-swaps-to-arrange-a-binary-grid/

给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
提示：
n == grid.length
n == grid[i].length
1 <= n <= 200
grid[i][j] 要么是 0 要么是 1 。

贪心。
首先预处理每行最后一个 1 的出现位置
假设当前第 i 行不满足条件，可以贪心选距离 i 行最近的满足条件的 j 行进行交换。
时间复杂度 O(n^2)
 */