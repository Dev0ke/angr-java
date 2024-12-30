public class Solution3145 {
    public int[] findProductsOfElements(long[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long l = queries[i][0], r = queries[i][1], mod = queries[i][2];
            ans[i] = (int) ksm(2, sumE(r + 1) - sumE(l), mod);
        }
        return ans;
    }

    private long sumE(long k) {
        long res = 0, n = 0, cnt1 = 0, sumI = 0;
        int bit_length = bitsLen(k + 1);
        for (long i = bit_length - 1; i > 0; i--) {
            long c = (cnt1 << i) + (i << (i - 1)); // 新增的幂次个数
            if (c <= k) {
                k -= c;
                res += (sumI << i) + ((i * (i - 1) / 2) << (i - 1));
                sumI += i; // 之前填的 1 的幂次之和
                cnt1++; // 之前填的 1 的个数
                n |= 1L << i; // 填 1
            }
        }
        // 最低位单独计算
        if (cnt1 <= k) {
            k -= cnt1;
            res += sumI;
            n++; // 填 1
        }
        // 剩余的 k 个幂次，由 n 的低 k 个 1 补充
        while (k-- > 0) {
            res += Long.numberOfTrailingZeros(n);
            n &= n - 1;
        }
        return res;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }

    private long ksm(long x, long k, long mod) {
        long ans = 1 % mod;
        while (k > 0) {
            if (k % 2 == 1) ans = ans * x % mod;
            x = x * x % mod;
            k >>= 1;
        }
        return ans;
    }
}
/*
3145. 大数组元素的乘积
https://leetcode.cn/problems/find-products-of-elements-of-big-array/description/

第 130 场双周赛 T4。

一个整数 x 的 强数组 指的是满足和为 x 的二的幂的最短有序数组。比方说，11 的强数组为 [1, 2, 8] 。
我们将每一个正整数 i （即1，2，3等等）的 强数组 连接得到数组 big_nums ，big_nums 开始部分为 [1, 2, 1, 2, 4, 1, 4, 2, 4, 1, 2, 4, 8, ...] 。
给你一个二维整数数组 queries ，其中 queries[i] = [fromi, toi, modi] ，你需要计算 (big_nums[fromi] * big_nums[fromi + 1] * ... * big_nums[toi]) % modi 。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
提示：
1 <= queries.length <= 500
queries[i].length == 3
0 <= queries[i][0] <= queries[i][1] <= 10^15
1 <= queries[i][2] <= 10^5

试填法。
时间复杂度 O(qlogr)。其中 q 为 queries 的长度，r = max(to_i)。
强数组的幂次
0 = []
1 = [0]
2 = [1]
3 = [0,1]
4 = [2]
5 = [0,2]
6 = [1,2]
7 = [0,1,2]
8 = [3]
1、前 k 个幂次的和
0,1,0,1,2,0,2,1,2,0,1,2,3
前 4 个幂次，来自前 3 个强数组的幂次
前 7 个幂次，来自前 5 个强数组的幂次
前 10 个幂次，来自前 6 个强数组的幂次，假设 7 的强数组的第一个幂次
2、前 n 个强数组总共有多少个幂次
已知 k，如何反推 n？
前 1 个强数组的总共有多少个幂次？0
前 2 个强数组的总共有多少个幂次？1
前 4 个强数组的总共有多少个幂次？4
前 8 个强数组的总共有多少个幂次？12
前 16 个强数组的总共有多少个幂次？
a(i) = 前 2^i 个强数组总共有多少个幂次，[0, 2^i-1] 中的 1 的个数
a(0) = 0
a(i+1) = a(i)*2 + 2^i
a(n) = n * 2^(n-1)
前 1 个强数组的幂次之和？0
前 2 个强数组的幂次之和？0
前 4 个强数组的幂次之和？2
前 8 个强数组的幂次之和？12
前 16 个强数组的幂次之和？
a(i) = 前 2^i 个强数组总共有多少个幂次，[0, 2^i-1] 中的 1 的个数
a(0) = 0
a(i+1) = a(i)*2 + i * 2^i
a(n) = n(n-1)/2 * 2^(n-1)
---
ones(2^i) = i \times 2^{i-1}
sumE(2^i) = \frac{i(i-1)}{2} \times 2^{i-1}
---
rating 2877 (clist.by)
 */