public class Solution3077 {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long[][] f = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            long w = (i % 2 > 0 ? 1 : -1) * (k - i + 1);

            long mx = Long.MIN_VALUE / 2;
            f[i][i - 1] = mx;
            for (int j = i; j < n - k + i + 1; j++) {
                // for (int L = i - 1; L <= j - 1; L++) {
                //     mx = Math.max(mx, f[i - 1][L] + (ps[j] - ps[L]) * w);
                // }
                // f[i][j] = Math.max(f[i][j - 1], mx);

                mx = Math.max(mx, f[i - 1][j - 1] - ps[j - 1] * w);
                f[i][j] = Math.max(f[i][j - 1], ps[j] * w + mx);
            }
        }
        return f[k][n];
    }
}
/*
3077. K 个不相交子数组的最大能量值
https://leetcode.cn/problems/maximum-strength-of-k-disjoint-subarrays/description/

第 388 场周赛 T4。

给你一个长度为 n 下标从 0 开始的整数数组 nums 和一个 正奇数 整数 k 。
x 个子数组的能量值定义为 strength = sum[1] * x - sum[2] * (x - 1) + sum[3] * (x - 2) - sum[4] * (x - 3) + ... + sum[x] * 1 ，其中 sum[i] 是第 i 个子数组的和。更正式的，能量值是满足 1 <= i <= x 的所有 i 对应的 (-1)i+1 * sum[i] * (x - i + 1) 之和。
你需要在 nums 中选择 k 个 不相交子数组 ，使得 能量值最大 。
请你返回可以得到的 最大能量值 。
注意，选出来的所有子数组 不 需要覆盖整个数组。
提示：
1 <= n <= 10^4
-10^9 <= nums[i] <= 10^9
1 <= k <= n
1 <= n * k <= 10^6
k 是奇数。

划分型 DP 不相交
状态包含两个信息：前多少个数，划分成多少段
1、通常来说，f[i][j] 表示前 j 个数分成 i 段，每段选一个子数组，对应的最大能量值
    nums[0] ~ nums[j-1]
2、不选 nums[j-1]：问题变成前 j-1 个数分成 i 段
    f[i][j] = f[i][j-1]
    f[i][j] = max(f[i-1][L] + (s[j]-s[L]) * w)
        L 最大是 j-1
        L 最小是 i-1
O(n^2 * k) = 10^10
f[i][j] = max(f[i][j-1], max_{L=i-1}^{j-1}  {f[i][j-1] + (s[j]-s[L]) * w_i} )
w_i = (-1)^(i+1) * (k-i+1)
答案 = f[k][n]
初始值 f[0][j] = 0
      f[i][i-1] = -inf
      f[i][<i] = -inf
时间复杂度 O(k(n-k))
空间复杂度 O(n)
rating 2586 (clist.by)
相似题目: 689. 三个无重叠子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 */