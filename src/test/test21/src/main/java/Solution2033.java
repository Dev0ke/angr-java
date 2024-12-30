import java.util.Arrays;

public class Solution2033 {
    public int minOperations(int[][] grid, int x) {
        int M = grid.length;
        int N = grid[0].length;
        int len = M * N;
        int[] flapGrid = new int[len];
        int idx = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                flapGrid[idx++] = grid[i][j];
            }
        }
        Arrays.sort(flapGrid);
        int target = flapGrid[len / 2];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(flapGrid[i] - target);
            if (diff % x == 0) {
                cnt += diff / x;
            } else {
                return -1;
            }
        }
        return cnt;
    }
}
/*
2033. 获取单值网格的最小操作数
https://leetcode.cn/problems/minimum-operations-to-make-a-uni-value-grid/

第 262 场周赛 T2。

给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
单值网格 是全部元素都相等的网格。
返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。

思路:
1.单值网格最终值大于数组最小值，小于数组最大值
2.单值网格最终值接近数组的平均值/中位数
3.单值网格最终值可等于数组的某个值
4.单值网格最终值数组排序后，下标为 n/2 的值
 */