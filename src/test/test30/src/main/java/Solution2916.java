public class Solution2916 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MAX_N = (int) (1e5 + 5);

    // old = a^2 + b^2 + c^2
    // new = (a+1)^2 + (b+1)^2 + (c+1)^2
    // = (a^2 + 2a + 1) + (b^2 + 2b + 1) + (c^2 + 2c + 1)
    // = (a^2 + b^2 + c^2) + 2(a+b+c) + 3
    // new = old + 2sum + n
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[] last = new int[MAX_N];
        SegmentTree seg = new SegmentTree(n);
        for (int i = 1; i <= n; i++) {
            int old = last[nums[i - 1]];
            seg.add1(old + 1, i);
            last[nums[i - 1]] = i;
            // 答案就是 [1, i] 这段区间的 sum2 之和
            ans = (ans + seg.getSum2(1, i)) % MOD;
        }
        return (int) ans;
    }

    private static class SegmentTree {
        int n;
        // sum1:区间和, sum2:区间平方和
        long[] sum1, sum2, lazy;

        public SegmentTree(int n) {
            this.n = n;
            this.sum1 = new long[n * 4];
            this.sum2 = new long[n * 4];
            this.lazy = new long[n * 4];
        }

        public void add1(int ql, int qr) {
            add1(1, 1, n, ql, qr);
        }

        public long getSum2(int ql, int qr) {
            return getSum2(1, 1, n, ql, qr);
        }

        // 根据公式维护区间加 K
        // sum2 = sum2 + 2 * k * sum1 + len * k * k; // len 是区间长度
        // sum1 = sum1 + len * k;
        void formula(int p, int l, int r, long k) {
            int len = r - l + 1;
            sum2[p] = (sum2[p] + 2 * k * sum1[p] + k * k % MOD * len) % MOD;
            sum1[p] = (sum1[p] + k * len) % MOD;
        }

        void pushDown(int p, int l, int r) {
            if (lazy[p] > 0) {
                int mid = l + (r - l) / 2;
                lazy[p << 1] += lazy[p];
                formula(p << 1, l, mid, lazy[p]);
                lazy[p << 1 | 1] += lazy[p];
                formula(p << 1 | 1, mid + 1, r, lazy[p]);
                lazy[p] = 0;
            }
        }

        // 区间加 1
        void add1(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                formula(p, l, r, 1);
                lazy[p]++;
                return;
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            if (ql <= mid) add1(p << 1, l, mid, ql, qr);
            if (qr > mid) add1(p << 1 | 1, mid + 1, r, ql, qr);
            pushUp(p);
        }

        void pushUp(int p) {
            sum1[p] = (sum1[p << 1] + sum1[p << 1 | 1]) % MOD;
            sum2[p] = (sum2[p << 1] + sum2[p << 1 | 1]) % MOD;
        }

        long getSum2(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return sum2[p];
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            long sum = 0;
            if (ql <= mid) sum = getSum2(p << 1, l, mid, ql, qr) % MOD;
            if (qr > mid) sum = (sum + getSum2(p << 1 | 1, mid + 1, r, ql, qr)) % MOD;
            return sum;
        }
    }
}
/*
2916. 子数组不同元素数目的平方和 II
https://leetcode.cn/problems/subarrays-distinct-element-sum-of-squares-ii/

第 116 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums 。
定义 nums 一个子数组的 不同计数 值如下：
- 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
请你返回 nums 中所有子数组的 不同计数 的 平方 和。
由于答案可能会很大，请你将它对 10^9 + 7 取余 后返回。
子数组指的是一个数组里面一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

数学 & 线段树
时间复杂度 O(nlogn)
参考:
https://leetcode.cn/circle/discuss/SwnhNk/
https://leetcode.cn/problems/subarrays-distinct-element-sum-of-squares-ii/solutions/2503065/shu-xue-xian-duan-shu-fen-bu-zou-xiang-j-pdy5/
https://www.luogu.com.cn/problem/P1972
https://codeforces.com/gym/104459/problem/F
https://atcoder.jp/contests/abc256/tasks/abc256_f
---
相似题目: 2913. 子数组不同元素数目的平方和 I
https://leetcode.cn/problems/subarrays-distinct-element-sum-of-squares-i/
2262. 字符串的总引力
https://leetcode.cn/problems/total-appeal-of-a-string/
828. 统计子串中的唯一字符
https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */