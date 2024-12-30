import java.util.Arrays;

public class Solution2382 {
    private static final long INF = (long) (1e5 * 1e9 + 10);

    // 137ms
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        MaxSubArraySegTree seg = new MaxSubArraySegTree(nums);

        int q = removeQueries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q - 1; i++) {
            seg.modify(removeQueries[i] + 1, -INF);
            ans[i] = seg.query(1, n);
        }
        return ans;
    }

    static class MaxSubArraySegTree {
        Node[] tree;
        static final int INF = (int) 1e9;

        static class Node {
            // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
            long maxL, maxR, maxSum, sum;

            public Node(long maxL, long maxR, long maxSum, long sum) {
                this.maxL = maxL;
                this.maxR = maxR;
                this.maxSum = maxSum;
                this.sum = sum;
            }
        }

        int[] nums;
        int n;

        public MaxSubArraySegTree(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            tree = new Node[4 * n];
            Arrays.setAll(tree, e -> new Node(0, 0, 0, 0));

            build(1, 1, n);
        }

        void build(int p, int l, int r) {
            if (l == r) {
                int val = nums[l - 1];
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            tree[p] = pushUp(tree[p << 1], tree[p << 1 | 1]);
        }

        // nums[pos] 修改为 val
        void modify(int pos, long val) {
            modify(1, 1, n, pos, val);
        }

        void modify(int p, int l, int r, int pos, long val) {
            if (l > pos || r < pos) {
                return;
            }
            if (l == pos && r == pos) {
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            modify(p << 1, l, mid, pos, val);
            modify(p << 1 | 1, mid + 1, r, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        // 查询 [l,r] 区间最大子段和
        long query(int ql, int qr) {
            return query(1, 1, n, ql, qr).maxSum;
        }

        Node query(int p, int l, int r, int ql, int qr) {
            if (l > qr || r < ql) {
                return new Node(-INF, -INF, -INF, 0);
            }
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            int mid = l + (r - l) / 2;
            Node ls = query(p << 1, l, mid, ql, qr);
            Node rs = query(p << 1 | 1, mid + 1, r, ql, qr);
            return pushUp(ls, rs);
        }

        Node pushUp(Node ls, Node rs) {
            long maxL = Math.max(ls.maxL, ls.sum + rs.maxL);
            long maxR = Math.max(rs.maxR, rs.sum + ls.maxR);
            // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
            long maxSum = Math.max(Math.max(ls.maxSum, rs.maxSum), ls.maxR + rs.maxL);
            long sum = ls.sum + rs.sum;
            return new Node(maxL, maxR, maxSum, sum);
        }
    }
}
/*
2382. 删除操作后的最大子段和
https://leetcode.cn/problems/maximum-segment-sum-after-removals/

第 85 场双周赛 T4。

给你两个下标从 0 开始的整数数组 nums 和 removeQueries ，两者长度都为 n 。对于第 i 个查询，nums 中位于下标 removeQueries[i] 处的元素被删除，将 nums 分割成更小的子段。
一个 子段 是 nums 中连续 正 整数形成的序列。子段和 是子段中所有元素的和。
请你返回一个长度为 n 的整数数组 answer ，其中 answer[i]是第 i 次删除操作以后的 最大 子段和。
注意：一个下标至多只会被删除一次。
提示：
n == nums.length == removeQueries.length
1 <= n <= 10^5
1 <= nums[i] <= 10^9
0 <= removeQueries[i] < n
removeQueries 中所有数字 互不相同 。

线段树
时间复杂度 O(nlogn)
 */