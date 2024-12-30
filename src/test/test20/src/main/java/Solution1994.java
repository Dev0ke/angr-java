public class Solution1994 {
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int MAX_N = 30;
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfGoodSubsets(int[] nums) {
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

        long res = 0;
        for (int mask = 1, maskMax = (1 << PRIMES.length); mask < maskMax; mask++) {
            res = (res + f[mask]) % MOD;
        }
        return (int) res;
    }
}
/*
1994. 好子集的数目
https://leetcode.cn/problems/the-number-of-good-subsets/

第 60 场双周赛 T4。

给你一个整数数组 nums 。如果 nums 的一个子集中，所有元素的乘积可以表示为一个或多个 互不相同的质数 的乘积，那么我们称它为 好子集 。
- 比方说，如果 nums = [1, 2, 3, 4] ：
  - [2, 3] ，[1, 2, 3] 和 [1, 3] 是 好 子集，乘积分别为 6 = 2*3 ，6 = 2*3 和 3 = 3 。
  - [1, 4] 和 [4] 不是 好 子集，因为乘积分别为 4 = 2*2 和 4 = 2*2 。
请你返回 nums 中不同的 好 子集的数目对 10^9 + 7 取余 的结果。
nums 中的 子集 是通过删除 nums 中一些（可能一个都不删除，也可能全部都删除）元素后剩余元素组成的数组。如果两个子集删除的下标不同，那么它们被视为不同的子集。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 30

状态压缩动态规划
时间复杂度 O(n + C * 2^π(C)) 其中 n = nums.length, C = max(nums[i]), 本题 C = 30, π(x) 表示 <= x 的质数个数
空间复杂度 O(2^π(C))
 */