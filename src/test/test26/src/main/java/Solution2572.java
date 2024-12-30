public class Solution2572 {
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int MAX_N = 30;
    private static final int MOD = (int) (1e9 + 7);

    public int squareFreeSubsets(int[] nums) {
        int[] freq = new int[MAX_N + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // f[i][mask] 表示当我们只选择 [2,i] 范围内的数，并且选择的数的质因数使用情况为 mask 时的方案数
        long[] f = new long[1 << PRIMES.length];
        f[0] = 1;
        for (int i = 0; i < freq[1]; i++) {
            f[0] = f[0] * 2 % MOD;
        }

        for (int i = 2; i <= MAX_N; i++) {
            if (freq[i] == 0) {
                continue;
            }

            // 检查 i 的每个质因数是否均不超过 1 个
            int subset = 0;
            int x = i;
            boolean check = true;
            for (int j = 0; j < PRIMES.length; j++) {
                int prime = PRIMES[j];
                if (x % (prime * prime) == 0) {
                    check = false;
                    break;
                }
                if (x % prime == 0) {
                    subset |= (1 << j);
                }
            }
            if (!check) {
                continue;
            }

            // 动态规划
            for (int mask = (1 << PRIMES.length) - 1; mask > 0; mask--) {
                if ((mask & subset) == subset) {
                    f[mask] = (f[mask] + f[mask ^ subset] * freq[i]) % MOD;
                }
            }
        }

        long res = -1L;
        for (int mask = 0; mask < (1 << PRIMES.length); mask++) {
            res = (res + f[mask]) % MOD;
        }
        return (int) res;
    }
}
/*
2572. 无平方子集计数
https://leetcode.cn/problems/count-the-number-of-square-free-subsets/

第 333 场周赛 T3。

给你一个正整数数组 nums 。
如果数组 nums 的子集中的元素乘积是一个 无平方因子数 ，则认为该子集是一个 无平方 子集。
无平方因子数 是无法被除 1 之外任何平方数整除的数字。
返回数组 nums 中 无平方 且 非空 的子集数目。因为答案可能很大，返回对 10^9 + 7 取余的结果。
nums 的 非空子集 是可以由删除 nums 中一些元素（可以不删除，但不能全部删除）得到的一个数组。如果构成两个子集时选择删除的下标不同，则认为这两个子集不同。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 30

状态压缩动态规划。
相似题目: 1994. 好子集的数目
https://leetcode.cn/problems/the-number-of-good-subsets/
 */