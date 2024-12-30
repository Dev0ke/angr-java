import java.util.Arrays;

public class Solution808 {
    private double[][] memo;

    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 179) {
            return 1.0;
        }
        memo = new double[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n, n);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        else if (a <= 0) return 1.0;
        else if (b <= 0) return 0;

        if (memo[a][b] != -1) return memo[a][b];
        double res = 0;
        res += 0.25 * dfs(a - 4, b);
        res += 0.25 * dfs(a - 3, b - 1);
        res += 0.25 * dfs(a - 2, b - 2);
        res += 0.25 * dfs(a - 1, b - 3);
        return memo[a][b] = res;
    }
}
/*
808. 分汤
https://leetcode.cn/problems/soup-servings/description/

有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
1.提供 100ml 的 汤A 和 0ml 的 汤B 。
2.提供 75ml 的 汤A 和 25ml 的 汤B 。
3.提供 50ml 的 汤A 和 50ml 的 汤B 。
4.提供 25ml 的 汤A 和 75ml 的 汤B 。
当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
注意 不存在先分配 100 ml 汤B 的操作。
需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
提示:
0 <= n <= 10^9

记忆化搜索。
时间复杂度 O(C^2)。
这道“中等”题的rating达到2396，曾经在周赛第三题top1的位置上坐了好几年（直到半年前被第295场周赛赶下去了）。
这道题是浮点数精度和概率论的完美结合，想要通过这道题就必须敢于写这个特判，而不能轻易怀疑二维DP的思路是错误的。
也许用数学期望去分析这个问题并不难，但看到这样的数据范围，又有多少人会坚信O(n^2)的做法是对的呢？
这正如人世间很多事情的成功，既需要足够的实力，也需要强大的内心。（另外可以直接return 1.的最小n值似乎是4451）
@Carl_Czerny
 */