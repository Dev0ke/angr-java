public class Solution3312 {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int[] cntX = new int[mx + 1];
        for (int x : nums) {
            cntX[x]++;
        }

        long[] cntGcd = new long[mx + 1];
        for (int i = mx; i > 0; i--) {
            int c = 0;
            for (int j = i; j <= mx; j += i) {
                c += cntX[j];
                cntGcd[i] -= cntGcd[j]; // gcd 是 2i,3i,4i,... 的数对不能统计进来
            }
            cntGcd[i] += (long) c * (c - 1) / 2; // c 个数选 2 个，组成 c*(c-1)/2 个数对
        }

        for (int i = 2; i <= mx; i++) {
            cntGcd[i] += cntGcd[i - 1]; // 原地求前缀和
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            ans[i] = upperBound(cntGcd, queries[i]);
        }
        return ans;
    }

    private int upperBound(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3312. 查询排序后的最大公约数
https://leetcode.cn/problems/sorted-gcd-pair-queries/description/

第 418 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个整数数组 queries 。
gcdPairs 表示数组 nums 中所有满足 0 <= i < j < n 的数对 (nums[i], nums[j]) 的 最大公约数 升序 排列构成的数组。
对于每个查询 queries[i] ，你需要找到 gcdPairs 中下标为 queries[i] 的元素。
请你返回一个整数数组 answer ，其中 answer[i] 是 gcdPairs[queries[i]] 的值。
gcd(a, b) 表示 a 和 b 的 最大公约数 。
提示：
2 <= n == nums.length <= 10^5
1 <= nums[i] <= 5 * 10^4
1 <= queries.length <= 10^5
0 <= queries[i] < n * (n - 1) / 2

枚举+容斥+前缀和+二分。
https://leetcode.cn/problems/sorted-gcd-pair-queries/solutions/2940415/mei-ju-rong-chi-qian-zhui-he-er-fen-pyth-ujis/
时间复杂度 O(n + (U+q)logU)。
rating 2514 (clist.by)
 */