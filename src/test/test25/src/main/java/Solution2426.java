import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2426 {
    static class V1 {
        private static final int OFFSET = (int) 1e4 * 3 + 5;

        public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
            int n = nums1.length;

            int[] nums1sub2 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1sub2[i] = nums1[i] - nums2[i];
            }

            DynamicSegTreeAdd seg = new DynamicSegTreeAdd();
            long res = 0;
            for (int i = 0; i < n; i++) {
                int idx = nums1sub2[i] + OFFSET;
                res += seg.getSum(1, idx);
                seg.add(idx - diff, idx - diff, 1);
            }
            return res;
        }

        private static class DynamicSegTreeAdd {
            private static final int N = Integer.MAX_VALUE;
            private final Node root = new Node();

            private static class Node {
                Node ls, rs;
                long sum, max, lazy;
            }

            // 区间 [l,r] 置为 val
            public void add(int l, int r, int val) {
                this.add(l, r, val, 1, N, root);
            }

            // 区间 [l,r] 求和
            public long getSum(int l, int r) {
                return this.getSum(l, r, 1, N, root);
            }

            private void add(int l, int r, int val, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    node.sum += (t - s + 1L) * val;
                    node.max += val;
                    node.lazy += val;
                    return;
                }
                int mid = s + (t - s) / 2;
                pushDown(node, s, t, mid);
                if (l <= mid) {
                    add(l, r, val, s, mid, node.ls);
                }
                if (r > mid) {
                    add(l, r, val, mid + 1, t, node.rs);
                }
                pushUp(node);
            }

            private long getSum(int l, int r, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    return node.sum;
                }
                int mid = s + (t - s) / 2;
                pushDown(node, s, t, mid);
                long sum = 0;
                if (l <= mid) {
                    sum = getSum(l, r, s, mid, node.ls);
                }
                if (r > mid) {
                    sum += getSum(l, r, mid + 1, t, node.rs);
                }
                return sum;
            }

            private void pushDown(Node node, int s, int t, int mid) {
                if (node.ls == null) {
                    node.ls = new Node();
                }
                if (node.rs == null) {
                    node.rs = new Node();
                }
                if (node.lazy > 0) {
                    node.ls.sum += node.lazy * (mid - s + 1L);
                    node.rs.sum += node.lazy * (t - mid);
                    node.ls.max += node.lazy;
                    node.rs.max += node.lazy;
                    node.ls.lazy += node.lazy;
                    node.rs.lazy += node.lazy;
                    node.lazy = 0;
                }
            }

            private void pushUp(Node node) {
                node.sum = node.ls.sum + node.rs.sum;
                node.max = Math.max(node.ls.max, node.rs.max);
            }
        }
    }

    static class V2 {
        public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
            int n = nums1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nums1[i] - nums2[i];
            }

            // 离散化
            int[] yArr = getDiscrete(a);

            int sz = yArr.length;
            BIT tr = new BIT(sz);

            long ans = 0;
            for (int i = 0; i < n; i++) {
                int j1 = lowerBound(yArr, a[i] + diff + 1);
                ans += tr.query(j1);
                int j2 = lowerBound(yArr, a[i]) + 1;
                tr.add(j2, 1);
            }
            return ans;
        }

        static int[] getDiscrete(int[] xArr) {
            Set<Integer> set = new HashSet<>(xArr.length);
            for (int x : xArr) set.add(x);
            int sz = set.size();
            int[] yArr = new int[sz];
            int id = 0;
            for (int x : set) yArr[id++] = x;
            Arrays.sort(yArr);
            return yArr;
        }

        private int lowerBound(int[] a, int key) {
            int l = 0, r = a.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a[m] >= key) r = m;
                else l = m + 1;
            }
            return l;
        }

        static class BIT {
            int n;
            int[] tree;

            public BIT(int n) {
                this.n = n;
                tree = new int[n + 1];
            }

            int lb(int x) {
                return x & -x;
            }

            void add(int pos, int val) {
                for (; pos <= n; pos += lb(pos)) tree[pos] += val;
            }

            int query(int pos) {
                int ret = 0;
                for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
                return ret;
            }
        }
    }
}
/*
2426. 满足不等式的数对数目
https://leetcode.cn/problems/number-of-pairs-satisfying-inequality/

第 88 场双周赛 T4。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, j) ：
- 0 <= i < j <= n - 1 且
- nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
请你返回满足条件的 数对数目 。
提示：
n == nums1.length == nums2.length
2 <= n <= 10^5
-10^4 <= nums1[i], nums2[i] <= 10^4
-10^4 <= diff <= 10^4

根据 nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff. 移项得 (nums1[i] - nums2[i]) <= (nums1[j] - nums2[j]) + diff
预处理每个 (nums1[i] - nums2[i]) 为 a[i] 结果为 a[i] <= a[j] + diff
即统计逆序对。可通过归并/树状数组/线段树求解，本题使用动态开点线段树 + 偏移量求解。
时间复杂度 O(nlogn)
 */