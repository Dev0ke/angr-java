public class Solution3244 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        SegTreeUpd_sum seg = new SegTreeUpd_sum(n);
        seg.update(1, n, 1);

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0] + 1, r = queries[i][1] + 1;
            seg.update(l + 1, r - 1, 0);
            ans[i] = (int) seg.getSum(1, n) - 1;
        }
        return ans;
    }

    static class SegTreeUpd_sum {
        int n;
        long[] tree, lazy_val;
        boolean[] lazy_tag;

        public SegTreeUpd_sum(int n) {
            this.n = n;
            this.tree = new long[4 * n];
            this.lazy_val = new long[4 * n];
            this.lazy_tag = new boolean[4 * n];
        }

        void update(int ql, int qr, int val) {
            update(1, 1, n, ql, qr, val);
        }

        void update(int p, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                tree[p] = val * (r - l + 1L);
                lazy_val[p] = val;
                lazy_tag[p] = true;
                return;
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
            if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getSum(int ql, int qr) {
            return getSum(1, 1, n, ql, qr);
        }

        long getSum(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            long sum = 0;
            if (ql <= mid) sum += getSum(p << 1, l, mid, ql, qr);
            if (qr > mid) sum += getSum(p << 1 | 1, mid + 1, r, ql, qr);
            return sum;
        }

        void pushDown(int p, int l, int r) {
            if (lazy_tag[p]) {
                int mid = l + (r - l) / 2;
                tree[p << 1] = lazy_val[p] * (mid - l + 1L);
                tree[p << 1 | 1] = lazy_val[p] * (r - mid);
                lazy_val[p << 1] = lazy_val[p];
                lazy_val[p << 1 | 1] = lazy_val[p];
                lazy_tag[p << 1] = true;
                lazy_tag[p << 1 | 1] = true;
                lazy_tag[p] = false;
            }
        }

        void pushUp(int p) {
            tree[p] = tree[p << 1] + tree[p << 1 | 1];
        }
    }
}
/*
3244. 新增道路查询后的最短距离 II
https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/description/

给你一个整数 n 和一个二维整数数组 queries。
有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
所有查询中不会存在两个查询都满足 queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1]。
返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
提示:
3 <= n <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= queries[i][0] < queries[i][1] < n
1 < queries[i][1] - queries[i][0]
查询中不存在重复的道路。
不存在两个查询都满足 i != j 且 queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1]。

注意到区间不会完全包含。区间内部缩点即可，线段树模拟。
注意 lazy_tag 的判断。之前的板子是 != 0 才下推懒标记，这会导致 update val=0 时不生效。
 */