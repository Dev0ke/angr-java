import java.util.Arrays;

public class Solution1494 {
    private int[] pre, memo;
    private int k, full;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.k = k;
        pre = new int[n];
        for (int[] r : relations) {
            // r[1] 的先修课程集合，下标改从 0 开始
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }

        full = (1 << n) - 1;
        memo = new int[1 << n];
        Arrays.fill(memo, -1);
        return dfs(full);
    }

    private int dfs(int i) {
        if (i == 0) return 0; // 空集
        if (memo[i] != -1) return memo[i]; // 之前算过了
        int ci = full ^ i; // i 的补集 complementary set
        int i1 = 0;
        for (int j = 0; j < pre.length; j++) {
            // pre1[j] 在 i 的补集中，可以学（否则这学期一定不能学）
            if ((i >> j & 1) == 1 && (pre[j] | ci) == ci) {
                i1 |= 1 << j;
            }
        }
        // 如果个数小于 k，则可以全部学习，不再枚举子集
        if (Integer.bitCount(i1) <= k) {
            return memo[i] = dfs(i ^ i1) + 1;
        }
        int res = Integer.MAX_VALUE;
        // 枚举 i1 的子集 j
        for (int j = i1; j > 0; j = (j - 1) & i1) {
            if (Integer.bitCount(j) == k) {
                res = Math.min(res, dfs(i ^ j) + 1);
            }
        }
        return memo[i] = res;
    }
}
/*
1494. 并行课程 II
https://leetcode.cn/problems/parallel-courses-ii/description/

给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中， relations[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
提示：
1 <= n <= 15
1 <= k <= n
0 <= relations.length <= n * (n-1) / 2
relations[i].length == 2
1 <= xi, yi <= n
xi != yi
所有先修关系都是不同的，也就是说 relations[i] != relations[j] 。
题目输入的图是个有向无环图。

子集状压 DP
时间复杂度 O(3^n)
空间复杂度 O(2^n)
 */