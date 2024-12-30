import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3041 {
    static class V1 {
        private static final int N = (int) (1e6 + 5);

        public int maxSelectedElements(int[] nums) {
            Arrays.sort(nums);
            DynamicSegTree seg = new DynamicSegTree();
            for (int x : nums) {
                int mx1 = seg.getMax(x - 1, x - 1);
                int mx2 = seg.getMax(x, x);
                seg.update(x, x, mx1 + 1);
                seg.update(x + 1, x + 1, mx2 + 1);
            }
            return seg.getMax(1, N);
        }

        private static class DynamicSegTree {
            static class Node {
                Node ls, rs;
                int max, lazy;
            }

            final Node root = new Node();

            void update(int l, int r, int val) {
                this.update(root, 0, N, l, r, val);
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

            int getMax(int l, int r) {
                return this.getMax(root, 0, N, l, r);
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

    static class V2 {
        public int maxSelectedElements(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> mp = new HashMap<>();
            for (int x : nums) {
                int mx1 = mp.getOrDefault(x - 1, 0);
                int mx2 = mp.getOrDefault(x, 0);
                mp.put(x, mx1 + 1);
                mp.put(x + 1, mx2 + 1);
            }
            return mp.values().stream().max(Integer::compareTo).orElseThrow();
        }
    }
}
/*
3041. 修改数组后最大化数组中的连续元素数目
https://leetcode.cn/problems/maximize-consecutive-elements-in-an-array-after-modification/description/

第 124 场双周赛 T4。

给你一个下标从 0 开始只包含 正 整数的数组 nums 。
一开始，你可以将数组中 任意数量 元素增加 至多 1 。
修改后，你可以从最终数组中选择 一个或者更多 元素，并确保这些元素升序排序后是 连续 的。比方说，[3, 4, 5] 是连续的，但是 [3, 4, 6] 和 [1, 1, 2, 3] 不是连续的。
请你返回 最多 可以选出的元素数目。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

按 2407 题思路，子序列 DP，使用动态开点线段树，赛时看错范围开了 1e5 惨吃罚时。
注意到本题是单点更新，而非区间更新，可以改用 HashMap 实现。
相似题目: 2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/
 */