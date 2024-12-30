public class Solution526 {
    public int countArrangement(int n) {
        // f[mask] 表示状态为 mask 时的可行方案总数，答案为 f[2^n -1]
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < 1 << n; mask++) {
            int bitCount = Integer.bitCount(mask);
            for (int k = 0; k < n; k++) {
                if (((mask >> k) & 1) == 1
                        && bitCount % (k + 1) == 0 || (k + 1) % bitCount == 0) {
                    f[mask] = f[mask] + f[mask ^ (1 << k)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
/*
526. 优美的排列
https://leetcode.cn/problems/beautiful-arrangement/

假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
- perm[i] 能够被 i 整除
- i 能够被 perm[i] 整除
给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
提示：
1 <= n <= 15

状态压缩动态规划
时间复杂度 O(n*2^n)
 */