public class SolutionP256 {
    /**
     * 剑指 Offer II 091. 粉刷房子
     * https://leetcode.cn/problems/JEj789/
     */
    public int minCost(int[][] costs) {
        int n = costs.length;

        // f[i][j] 表示粉刷 [0, i] 行的房子且第 i 行房子颜色为 j 时的最小花费
        // 滚动数组压缩掉 i
        int[] f = new int[3];
        // 初始状态
        for (int j = 0; j < 3; j++) {
            f[j] = costs[0][j];
        }
        // 状态转移
        for (int i = 1; i < n; i++) {
            int[] f1 = new int[3];
            for (int j = 0; j < 3; j++) {
                f1[j] = Math.min(f[(j + 1) % 3], f[(j + 2) % 3]) + costs[i][j];
            }
            f = f1;
        }

        int min = f[0];
        for (int j = 1; j < 3; j++) {
            min = Math.min(min, f[j]);
        }
        return min;
    }
}
/*
$256. 粉刷房子
https://leetcode.cn/problems/paint-house/

假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
请计算出粉刷完所有房子最少的花费成本。
提示:
costs.length == n
costs[i].length == 3
1 <= n <= 100
1 <= costs[i][j] <= 20

动态规划。
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: $265. 粉刷房子 II
https://leetcode.cn/problems/paint-house-ii/
 */