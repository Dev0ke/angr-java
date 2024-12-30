import java.util.Arrays;

public class Solution3290 {
    private int[] a, b;
    private int n;
    private long[][] memo;

    public long maxScore(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        n = b.length;

        memo = new long[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    // 选了 j 个
    private long dfs(int i, int j) {
        if (i == n) {
            if (j == 4) return 0;
            return (long) -1e18;
        }
        if (memo[i][j] != -1) return memo[i][j];
        // 不选
        long res = dfs(i + 1, j);
        // 选
        if (j < 4) {
            res = Math.max(res, dfs(i + 1, j + 1) + (long) a[j] * b[i]);
        }
        return memo[i][j] = res;
    }
}
/*
3290. 最高乘法得分
https://leetcode.cn/problems/maximum-multiplication-score/description/

第 415 场周赛 T2。

给你一个大小为 4 的整数数组 a 和一个大小 至少为 4 的整数数组 b。
你需要从数组 b 中选择四个下标 i0, i1, i2, 和 i3，并满足 i0 < i1 < i2 < i3。你的得分将是 a[0] * b[i0] + a[1] * b[i1] + a[2] * b[i2] + a[3] * b[i3] 的值。
返回你能够获得的 最大 得分。
提示：
a.length == 4
4 <= b.length <= 10^5
-10^5 <= a[i], b[i] <= 10^5

记忆化搜索。
时间复杂度 O(4n)。
 */