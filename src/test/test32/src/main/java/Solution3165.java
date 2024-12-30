public class Solution3165 {
    private static final int MOD = (int) (1e9 + 7);

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        long ans = 0;
        SegmentTree seg = new SegmentTree(nums);
        for (int[] p : queries) {
            int pos = p[0], x = p[1];
            seg.update(pos, x);
            ans += seg.tree[1][3]; // 注意 f11 没有任何限制，也就是整个数组的打家劫舍
        }
        return (int) (ans % MOD);
    }

    static class SegmentTree {
        int n;
        // 4 个数分别保存 f00, f01, f10, f11
        long[][] tree;
        int[] nums;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new long[4 * n][4];
            this.nums = nums;
            build(1, 0, n - 1);
        }

        void pushUp(int p) {
            long[] a = tree[p * 2], b = tree[p * 2 + 1];
            tree[p] = new long[]{
                    Math.max(a[0] + b[2], a[1] + b[0]),
                    Math.max(a[0] + b[3], a[1] + b[1]),
                    Math.max(a[2] + b[2], a[3] + b[0]),
                    Math.max(a[2] + b[3], a[3] + b[1])
            };
        }

        void build(int p, int l, int r) {
            if (l == r) {
                tree[p][3] = Math.max(0, nums[l]);
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            pushUp(p);
        }

        void update(int i, int val) {
            update(1, 0, n - 1, i, val);
        }

        void update(int p, int l, int r, int i, int val) {
            if (l == r) {
                tree[p][3] = Math.max(0, val);
                return;
            }
            int mid = l + (r - l) / 2;
            if (i <= mid) update(p << 1, l, mid, i, val);
            else update(p << 1 | 1, mid + 1, r, i, val);
            pushUp(p);
        }
    }
}
/*
3165. 不包含相邻元素的子序列的最大和
https://leetcode.cn/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/description/

第 399 场周赛 T4。

给你一个整数数组 nums 和一个二维数组 queries，其中 queries[i] = [posi, xi]。
对于每个查询 i，首先将 nums[posi] 设置为 xi，然后计算查询 i 的答案，该答案为 nums 中 不包含相邻元素 的子序列的 最大 和。
返回所有查询的答案之和。
由于最终答案可能非常大，返回其对 10^9 + 7 取余 的结果。
子序列 是指从另一个数组中删除一些或不删除元素而不改变剩余元素顺序得到的数组。
提示：
1 <= nums.length <= 5 * 10^4
-10^5 <= nums[i] <= 10^5
1 <= queries.length <= 5 * 10^4
queries[i] == [posi, xi]
0 <= posi <= nums.length - 1
-10^5 <= xi <= 10^5

分治思想 + 线段树。
时间复杂度 O((n + q) logn)。
能否分治解决不带修改的版本？
能 -> 用线段树动态维护带修改的版本
f00(a) 在不选 a 的第一个数和最后一个数的情况下，计算打家劫舍的答案
f01(a) 在不选 a 的第一个数的情况下，计算打家劫舍的答案（最后一个数可选可不选）
f10(a) 在不选 a 的最后一个数的情况下，计算打家劫舍的答案（第一个数可选可不选）
f11(a) 计算打家劫舍的答案（第一个数可选可不选，最后一个数可选可不选）
p = a[:len(a)//2]
q = a[len(a)//2:]
f11(a) = max(f10(p) + f11(q), f11(p) + f01(q))
递归边界 f11(a) = max(a[0], 0)
rating 2713 (clist.by)
相似题目: P3097 [USACO13DEC] Optimal Milking G
https://www.luogu.com.cn/problem/P3097
 */