import java.util.Arrays;

public class SolutionP2907 {
    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int maxPrice = Arrays.stream(prices).max().orElseThrow();
        SegTreeUpd_max seg1 = new SegTreeUpd_max(maxPrice + 5);
        SegTreeUpd_max seg2 = new SegTreeUpd_max(maxPrice + 5);

        // 前后缀分解
        long[] L = new long[n], R = new long[n];
        for (int i = 0; i < n; i++) {
            int idx = prices[i];
            L[i] = seg1.getMax(1, idx - 1);
            seg1.update(idx, profits[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = prices[i];
            R[i] = seg2.getMax(idx + 1, maxPrice);
            seg2.update(idx, profits[i]);
        }

        int ans = -1;
        for (int i = 1; i < n - 1; i++) {
            if (L[i] > 0 && R[i] > 0) {
                ans = (int) Math.max(ans, L[i] + profits[i] + R[i]);
            }
        }
        return ans;
    }

    static class SegTreeUpd_max {
        int n;
        int[] tree;

        public SegTreeUpd_max(int n) {
            this.n = n;
            this.tree = new int[4 * n];
        }

        void update(int pos, int val) {
            update(1, 1, n, pos, val);
        }

        void update(int p, int l, int r, int pos, int val) {
            if (l == r) {
                // 单点更新，且只有 val 大于当前值时才更新
                tree[p] = Math.max(tree[p], val);
                return;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            if (pos <= mid) update(p << 1, l, mid, pos, val);
            else update(p << 1 | 1, mid + 1, r, pos, val);
            pushUp(p);
        }

        long getMax(int ql, int qr) {
            if (ql > qr) return 0;
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
        }

        void pushUp(int p) {
            tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
        }
    }
}
/*
$2907. 价格递增的最大利润三元组 I
https://leetcode.cn/problems/maximum-profitable-triplets-with-increasing-prices-i/description/

给定两个长度为 n 的 下标从 0 开始 的数组 prices 和 profits。商店里有 n 件商品，其中第 i 件商品的价格为 prices[i]，利润为 profits[i]。
我们必须按照以下条件选择三件商品：
- prices[i] < prices[j] < prices[k]，其中 i < j < k。
如果我们选择满足上述条件的索引 i，j 和 k 的商品，那么利润就是 profits[i] + profits[j] + profits[k]。
返回我们能得到的最大利润，如果无法选择三件满足条件的商品，则返回 -1。
提示：
3 <= prices.length == profits.length <= 2000
1 <= prices[i] <= 10^6
1 <= profits[i] <= 10^6

单点更新，区间查询最大值。
线段树。
相似题目: $2921. 价格递增的最大利润三元组 II
https://leetcode.cn/problems/maximum-profitable-triplets-with-increasing-prices-ii/description/
 */