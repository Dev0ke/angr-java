public class Solution2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;

        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int[] ints : grid) {
                int len = String.valueOf(ints[j]).length();
                max = Math.max(max, len);
            }
            res[j] = max;
        }
        return res;
    }
}
/*
2639. 查询网格图中每一列的宽度
https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid/

第 102 场双周赛 T1。

给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度 。
- 比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。
请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。
一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-10^9 <= grid[r][c] <= 10^9

模拟。
时间复杂度 O(mnlogU)。其中 U 表示最大值 1e9。
 */