public class Solution2926 {
    private static final int N = (int) (1e9 + 5);

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        DynamicSegTree seg = new DynamicSegTree();
        for (int i = 0; i < n; i++) {
            int j = nums[i] - i;
            long f = Math.max(0, seg.getMax(-N, j)) + nums[i];
            seg.update(j, j, f);
        }
        return seg.getMax(-N, N);
    }

    private static class DynamicSegTree {
        static class Node {
            Node ls, rs;
            long max = Long.MIN_VALUE, lazy;
        }

        final Node root = new Node();

        // 区间更新 [l,r] 置为 val
        void update(int l, int r, long val) {
            this.update(root, -N, N, l, r, val);
        }

        // 区间查询 [l,r] 最大值
        long getMax(int l, int r) {
            return this.getMax(root, -N, N, l, r);
        }

        void update(Node p, int l, int r, int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                p.max = val;
                p.lazy = val;
                return;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
            if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getMax(Node p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return p.max;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            long max = Long.MIN_VALUE;
            if (ql <= mid) max = Math.max(max, getMax(p.ls, l, mid, ql, qr));
            if (qr > mid) max = Math.max(max, getMax(p.rs, mid + 1, r, ql, qr));
            return max;
        }

        void pushDown(Node p) {
            if (p.ls == null) p.ls = new Node();
            if (p.rs == null) p.rs = new Node();
            if (p.lazy > 0) {
                p.ls.max = p.lazy;
                p.rs.max = p.lazy;
                p.ls.lazy = p.lazy;
                p.rs.lazy = p.lazy;
                p.lazy = 0;
            }
        }

        void pushUp(Node p) {
            p.max = Math.max(p.ls.max, p.rs.max);
        }
    }
}
/*
2926. 平衡子序列的最大和
https://leetcode.cn/problems/maximum-balanced-subsequence-sum/description/

第 370 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 。
nums 一个长度为 k 的 子序列 指的是选出 k 个 下标 i0 < i1 < ... < ik-1 ，如果这个子序列满足以下条件，我们说它是 平衡的 ：
- 对于范围 [1, k - 1] 内的所有 j ，nums[ij] - nums[ij-1] >= ij - ij-1 都成立。
nums 长度为 1 的 子序列 是平衡的。
请你返回一个整数，表示 nums 平衡 子序列里面的 最大元素和 。
一个数组的 子序列 指的是从原数组中删除一些元素（也可能一个元素也不删除）后，剩余元素保持相对顺序得到的 非空 新数组。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

权值线段树（区间加法线段树）
时间复杂度 O(nlogn)
相似题目: 2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/
 */