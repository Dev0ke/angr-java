public class Solution2407 {
    private static final int N = (int) 1e5;

    public int lengthOfLIS(int[] nums, int k) {
        DynamicSegTree seg = new DynamicSegTree();
        for (int x : nums) {
            int max = seg.getMax(x - k, x - 1);
            seg.update(x, x, max + 1);
        }
        return seg.getMax(1, N);
    }

    private static class DynamicSegTree {
        static class Node {
            Node ls, rs;
            int max, lazy;
        }

        final Node root = new Node();

        // 区间更新 [l,r] 置为 val
        void update(int l, int r, int val) {
            this.update(root, 0, N, l, r, val);
        }

        // 区间查询 [l,r] 最大值
        int getMax(int l, int r) {
            return this.getMax(root, 0, N, l, r);
        }

        void update(Node p, int l, int r, int ql, int qr, int val) {
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

        int getMax(Node p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return p.max;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            int max = 0;
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
2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/

第 310 场周赛 T4。

给你一个整数数组 nums 和一个整数 k 。
找到 nums 中满足以下要求的最长子序列：
- 子序列 严格递增
- 子序列中相邻元素的差值 不超过 k 。
请你返回满足上述要求的 最长子序列 的长度。
子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^5

LIS 的线段树做法，比赛时只会 O(nlogn) 的 贪心+二分 的解法。然后发现单调栈无法处理这个 k。。
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
2926. 平衡子序列的最大和
https://leetcode.cn/problems/maximum-balanced-subsequence-sum/description/
 */