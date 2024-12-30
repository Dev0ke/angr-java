import java.util.Arrays;

public class Solution2500 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int sum = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }
        return sum;
    }
}
/*
2500. 删除每行中的最大值
https://leetcode.cn/problems/delete-greatest-value-in-each-row/

第 323 场周赛 T1。

给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
执行下述操作，直到 grid 变为空矩阵：
- 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
- 将删除元素中的最大值与答案相加。
注意 每执行一次操作，矩阵中列的数据就会减 1 。
返回执行上述操作后的答案。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 100

每行排序后暴力
时间复杂度 O(mnlogn)
 */