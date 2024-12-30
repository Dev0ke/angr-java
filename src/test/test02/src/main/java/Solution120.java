import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 三角形的高度
        int h = triangle.size();
        // f[i][j] 为自底向上到 [i,j] 的最小路径和。+1 避免最后一层越界
        int[][] f = new int[h + 1][h + 1];
        // 状态转移
        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }
}
/*
120. 三角形最小路径和
https://leetcode.cn/problems/triangle/

给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-10^4 <= triangle[i][j] <= 10^4
进阶：
你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？

本题是一道非常经典且历史悠久的动态规划题，其作为算法题出现，最早可以追溯到 1994 年的 IOI（国际信息学奥林匹克竞赛）的 The Triangle。
https://ioinformatics.org/files/ioi1994problem1.pdf
时光飞逝，经过 20 多年的沉淀，往日的国际竞赛题如今已经变成了动态规划的入门必做题，不断督促着我们学习和巩固算法。
动态规划。可以 自顶向下 或者 自底向上
自底向上可以规避一些边界条件。定义 dp[i][j] 为自底向上到 i,j 的最小路径和
         (0,0)
      (1,0) (1,1)
   (2,0) (2,1) (2,2)
(3,0) (3,1) (3,2) (3,3)
dp(2,0) = min((3,0), (3,1)) + (2,0)
时间复杂度 O(n^2)
空间复杂度 O(n^2) 可优化到 空间复杂度 O(n)
 */