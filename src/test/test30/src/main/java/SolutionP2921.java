import java.util.Arrays;

public class SolutionP2921 {
    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int maxPrice = Arrays.stream(prices).max().orElseThrow();

        // 前后缀分解
        int[] L = new int[n];
        BIT tr1 = new BIT(maxPrice + 1);
        for (int i = 0; i < n; ++i) {
            int x = prices[i];
            L[i] = tr1.query(x - 1);
            tr1.update(x, profits[i]);
        }
        int[] R = new int[n];
        BIT tr2 = new BIT(maxPrice + 1);
        for (int i = n - 1; i >= 0; i--) {
            // seg2.getMax(x + 1, maxPrice);
            int x = maxPrice + 1 - prices[i];
            R[i] = tr2.query(x - 1);
            tr2.update(x, profits[i]);
        }

        int ans = -1;
        for (int i = 1; i < n - 1; i++) {
            if (L[i] > 0 && R[i] > 0) {
                ans = Math.max(ans, L[i] + profits[i] + R[i]);
            }
        }
        return ans;
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

        void update(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] = Math.max(tree[pos], val);
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret = Math.max(ret, tree[pos]);
            return ret;
        }
    }
}
/*
$2921. 价格递增的最大利润三元组 II
https://leetcode.cn/problems/maximum-profitable-triplets-with-increasing-prices-ii/description/

给定长度为 n  的数组 prices 和 profits （下标从 0 开始）。一个商店有 n 个商品，第 i 个商品的价格为 prices[i]，利润为 profits[i]。
需要选择三个商品，满足以下条件：
- prices[i] < prices[j] < prices[k]，其中 i < j < k。
如果选择的商品 i, j 和 k 满足以下条件，那么利润将等于 profits[i] + profits[j] + profits[k]。
返回能够获得的 最大利润，如果不可能满足给定条件，返回 -1。
提示：
3 <= prices.length == profits.length <= 50000
1 <= prices[i] <= 5000
1 <= profits[i] <= 10^6

单点更新，区间查询最大值。
树状数组。
相似题目: $2907. 价格递增的最大利润三元组 I
https://leetcode.cn/problems/maximum-profitable-triplets-with-increasing-prices-i/description/
 */