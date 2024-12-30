import java.util.Arrays;

public class Solution3193 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfPermutations(int n, int[][] requirements) {
        int k = 0;
        int[] A = new int[n + 1];
        Arrays.fill(A, -1);
        for (int[] p : requirements) {
            k = Math.max(k, p[1]);
            A[p[0] + 1] = p[1]; // 下标从 1 开始
        }

        long[][] f = new long[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            if (A[i] == -1) { // 同 629 题，前缀和优化 DP
                for (int j = 0; j <= k; j++) {
                    f[i][j] = (j - 1 >= 0 ? f[i][j - 1] : 0) - (j - i >= 0 ? f[i - 1][j - i] : 0) + f[i - 1][j];
                    f[i][j] %= MOD;
                }
            } else { // 只更新满足 requirements[i] = [endi, cnti] 的
                int j = A[i];
                for (int det = 0; det <= i - 1 && j - det >= 0; det++) {
                    f[i][j] += f[i - 1][j - det];
                    f[i][j] %= MOD;
                }
            }
        }
        return (int) (f[n][k] + MOD) % MOD;
    }
}
/*
3193. 统计逆序对的数目
https://leetcode.cn/problems/count-the-number-of-inversions/description/

第 133 场双周赛 T4。

给你一个整数 n 和一个二维数组 requirements ，其中 requirements[i] = [endi, cnti] 表示这个要求中的末尾下标和 逆序对 的数目。
整数数组 nums 中一个下标对 (i, j) 如果满足以下条件，那么它们被称为一个 逆序对 ：
- i < j 且 nums[i] > nums[j]
请你返回 [0, 1, 2, ..., n - 1] 的 排列 perm 的数目，满足对 所有 的 requirements[i] 都有 perm[0..endi] 恰好有 cnti 个逆序对。
由于答案可能会很大，将它对 10^9 + 7 取余 后返回。
提示：
2 <= n <= 300
1 <= requirements.length <= n
requirements[i] = [endi, cnti]
0 <= endi <= n - 1
0 <= cnti <= 400
输入保证至少有一个 i 满足 endi == n - 1 。
输入保证所有的 endi 互不相同。

前缀和优化 DP。
时间复杂度 O(nk)。
相似题目: 629. K个逆序对数组
https://leetcode.cn/problems/k-inverse-pairs-array/
 */