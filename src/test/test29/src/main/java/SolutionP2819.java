import java.util.Arrays;

public class SolutionP2819 {
    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        int n = prices.length;
        Arrays.sort(prices);
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + prices[i];
        }

        int m = queries.length;
        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            int ki = queries[i][0], mi = queries[i][1];
            if (n == mi) {
                int x = upperBound(prices, ki);
                res[i] = ps[x] + (long) ki * (n - x) * 2 - (ps[n] - ps[x]);
                continue;
            }

            int need = n - mi;

            int l = 0;
            int r = mi;
            while (l < r) {
                int mid = l + (r - l) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (ki - prices[mid] <= prices[mid + need] - ki) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int idx = l;

            long left = ps[idx];
            long right = (long) ki * (n - idx - need) * 2 - (ps[n] - ps[idx + need]);
            res[i] = left + right;
        }

        return res;
    }

    private int upperBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
$2819. 购买巧克力后的最小相对损失
https://leetcode.cn/problems/minimum-relative-loss-after-buying-chocolates/description/

现给定一个整数数组 prices，表示巧克力的价格；以及一个二维整数数组 queries，其中 queries[i] = [ki, mi]。
Alice 和 Bob 去买巧克力，Alice 提出了一种付款方式，而 Bob 同意了。
对于每个 queries[i] ，它的条件如下：
- 如果一块巧克力的价格 小于等于 ki，那么 Bob 为它付款。
- 否则，Bob 为其中 ki 部分付款，而 Alice 为 剩余 部分付款。
Bob 想要选择 恰好 mi 块巧克力，使得他的 相对损失最小 。更具体地说，如果总共 Alice 付款了 ai，Bob 付款了 bi，那么 Bob 希望最小化 bi - ai。
返回一个整数数组 ans，其中 ans[i] 是 Bob 在 queries[i] 中可能的 最小相对损失 。
提示：
1 <= prices.length == n <= 10^5
1 <= prices[i] <= 10^9
1 <= queries.length <= 10^5
queries[i].length == 2
1 <= ki <= 10^9
1 <= mi <= n

二分优化 + 滑动窗口。
时间复杂度 O(mlogn)。
 */