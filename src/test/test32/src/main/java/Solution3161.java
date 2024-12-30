import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution3161 {
    public List<Boolean> getResults(int[][] queries) {
        final int mx = (int) 5e4 + 5;
        final int offset = 1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(offset); // 哨兵
        treeSet.add(mx); // 哨兵

        SegTreeUpd_max seg = new SegTreeUpd_max(mx);
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] p : queries) {
            int op = p[0], x = p[1] + offset;
            if (op == 1) {
                Integer lower = treeSet.lower(x);
                Integer higher = treeSet.higher(x);
                int L1 = x - lower;
                int L2 = higher - x;
                seg.update(x, x, L1);
                seg.update(higher, higher, L2);
                treeSet.add(x);
            } else {
                int sz = p[2];
                Integer floor = treeSet.floor(x);
                long max_sz = Math.max(seg.getMax(offset, x), x - floor);
                ans.add(max_sz >= sz);
            }
        }
        return ans;
    }

    static class SegTreeUpd_max {
        int n;
        long[] tree, lazy;

        public SegTreeUpd_max(int n) {
            this.n = n;
            this.tree = new long[4 * n];
            this.lazy = new long[4 * n];
        }

        void update(int ql, int qr, int val) {
            update(1, 1, n, ql, qr, val);
        }

        void update(int p, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                tree[p] = val;
                lazy[p] = val;
                return;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
            if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getMax(int ql, int qr) {
            return getMax(1, 1, n, ql, qr);
        }

        long getMax(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            long max = 0;
            if (ql <= mid) max = Math.max(max, getMax(p << 1, l, mid, ql, qr));
            if (qr > mid) max = Math.max(max, getMax(p << 1 | 1, mid + 1, r, ql, qr));
            return max;
        }

        void pushDown(int p) {
            if (lazy[p] != 0) {
                tree[p << 1] = lazy[p];
                tree[p << 1 | 1] = lazy[p];
                lazy[p << 1] = lazy[p];
                lazy[p << 1 | 1] = lazy[p];
                lazy[p] = 0;
            }
        }

        void pushUp(int p) {
            tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
        }
    }
}
/*
3161. 物块放置查询
https://leetcode.cn/problems/block-placement-queries/description/

第 131 场双周赛 T4。

有一条无限长的数轴，原点在 0 处，沿着 x 轴 正 方向无限延伸。
给你一个二维数组 queries ，它包含两种操作：
1.操作类型 1 ：queries[i] = [1, x] 。在距离原点 x 处建一个障碍物。数据保证当操作执行的时候，位置 x 处 没有 任何障碍物。
2.操作类型 2 ：queries[i] = [2, x, sz] 。判断在数轴范围 [0, x] 内是否可以放置一个长度为 sz 的物块，这个物块需要 完全 放置在范围 [0, x] 内。
如果物块与任何障碍物有重合，那么这个物块 不能 被放置，但物块可以与障碍物刚好接触。注意，你只是进行查询，并 不是 真的放置这个物块。每个查询都是相互独立的。
请你返回一个 boolean 数组results ，如果第 i 个操作类型 2 的操作你可以放置物块，那么 results[i] 为 true ，否则为 false 。
提示：
1 <= queries.length <= 15 * 10^4
2 <= queries[i].length <= 3
1 <= queries[i][0] <= 2
1 <= x, sz <= min(5 * 10^4, 3 * queries.length)
输入保证操作 1 中，x 处不会有障碍物。
输入保证至少有一个操作类型 2 。

平衡树 + 线段树。
平衡树用于找到插入点的前驱和后继，线段树维护 [0,x] 段最大值。
设插入一个点 x，前驱是 lo，后继是 hi，则长度 L(=hi-lo) 被截断成 L1(=x-lo) + L2(=hi-x)。
时间复杂度 O(qlogq)。
rating 2542 (clist.by)
 */