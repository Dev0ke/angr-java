import java.util.List;

public class Solution2861 {
    private int n, k, budget;
    private List<Integer> comp, stock, cost;

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        this.n = n;
        this.k = k;
        this.budget = budget;
        this.stock = stock;
        this.cost = cost;

        int ans = 0;
        for (List<Integer> list : composition) {
            this.comp = list;
            int b = maxNumberOfAlloys();
            ans = Math.max(ans, b);
        }
        return ans;
    }

    private int maxNumberOfAlloys() {
        int left = 1;
        int right = (int) (2e8 + 5);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(long mid) {
        long need = 0;
        for (int i = 0; i < n; i++) {
            long j = Math.max(0, mid * comp.get(i) - stock.get(i));
            need += j * cost.get(i);
        }
        return need <= budget;
    }
}
/*
2861. 最大合金数
https://leetcode.cn/problems/maximum-number-of-alloys/

第 363 场周赛 T3。

假设你是一家合金制造公司的老板，你的公司使用多种金属来制造合金。现在共有 n 种不同类型的金属可以使用，并且你可以使用 k 台机器来制造合金。每台机器都需要特定数量的每种金属来创建合金。
对于第 i 台机器而言，创建合金需要 composition[i][j] 份 j 类型金属。最初，你拥有 stock[i] 份 i 类型金属，而每购入一份 i 类型金属需要花费 cost[i] 的金钱。
给你整数 n、k、budget，下标从 1 开始的二维数组 composition，两个下标从 1 开始的数组 stock 和 cost，请你在预算不超过 budget 金钱的前提下，最大化 公司制造合金的数量。
所有合金都需要由同一台机器制造。
返回公司可以制造的最大合金数。
提示：
1 <= n, k <= 100
0 <= budget <= 10^8
composition.length == k
composition[i].length == n
1 <= composition[i][j] <= 100
stock.length == cost.length == n
0 <= stock[i] <= 10^8
1 <= cost[i] <= 100

二分答案。
时间复杂度 O(nlogU) 其中 U 为上界 2e8
 */