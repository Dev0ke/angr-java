import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2944 {
    private int[][] memo;

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        memo = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(prices, 0, 0);
    }

    // [0,j)
    private int dfs(int[] prices, int i, int j) {
        int n = prices.length;
        if (j >= n) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = (int) 1e9;
        // 选
        res = Math.min(res, dfs(prices, i + 1, Math.max(j, (i + 1) + (i + 1))) + prices[i]);
        // 不选
        if (j > i) {
            res = Math.min(res, dfs(prices, i + 1, j));
        }
        return memo[i][j] = res;
    }

    // 赛后补充：

    // 记忆化搜索 O(n^2)
    private int[] memo1;

    public int minimumCoins1(int[] prices) {
        int n = prices.length;
        memo1 = new int[n + 1];
        Arrays.fill(memo1, -1);
        return dfs(prices, 1);
    }

    private int dfs(int[] prices, int i) {
        int n = prices.length;
//        if (i > n) return 0;
        if (i * 2 >= n) return prices[i - 1];
        if (memo1[i] != -1) return memo1[i];
        int res = (int) 1e9;
        for (int j = i + 1; j < (i + 1) + (i + 1); j++) {
            res = Math.min(res, dfs(prices, j));
        }
        res += prices[i - 1];
        return memo1[i] = res;
    }

    // 递推 O(n^2)
    public int minimumCoins2(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            if (i * 2 >= n) {
                f[i] = prices[i - 1];
            } else {
                int res = (int) 1e9;
                for (int j = i + 1; j < (i + 1) + (i + 1); j++) {
                    res = Math.min(res, f[j]);
                }
                f[i] = res + prices[i - 1];
            }
        }
        return f[1];
    }

    // 单调队列优化 O(n)
    public int minimumCoins3(int[] prices) {
        int n = prices.length;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n + 1, 0});
        for (int i = n; i >= 1; i--) {
            // 1、弹出离开窗口的元素
            while (q.getLast()[0] > 2 * i + 1) {
                q.removeLast();
            }
            // 2、转移
            int f = q.getLast()[1] + prices[i - 1];
            // 3、把 f 入队首
            while (f <= q.getFirst()[1]) {
                q.removeFirst();
            }
            q.addFirst(new int[]{i, f});
        }
        return q.getFirst()[1];
    }
}
/*
2944. 购买水果需要的最少金币数
https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/description/

第 118 场双周赛 T3。

你在一个水果超市里，货架上摆满了玲琅满目的奇珍异果。
给你一个下标从 1 开始的数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
水果超市有如下促销活动：
- 如果你花费 price[i] 购买了水果 i ，那么接下来的 i 个水果你都可以免费获得。
注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以便能免费获得接下来的 j 个水果。
请你返回获得所有水果所需要的 最少 金币数。
提示：
1 <= prices.length <= 1000
1 <= prices[i] <= 10^5

动态规划
时间复杂度 O(n^2)
可用单调队列优化至 O(n)
相似题目: 1425. 带限制的子序列和
https://leetcode.cn/problems/constrained-subsequence-sum/description/
$2969. 购买水果需要的最少金币数 II
https://leetcode.cn/problems/minimum-number-of-coins-for-fruits-ii/description/
 */