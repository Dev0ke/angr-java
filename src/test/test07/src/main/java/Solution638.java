import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution638 {
    private List<Integer> price;
    private List<List<Integer>> special;
    private int n;
    private Map<List<Integer>, Integer> memo;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        this.n = price.size();

        memo = new HashMap<>();
        return dfs(needs);
    }

    private int dfs(List<Integer> curNeeds) {
        if (memo.containsKey(curNeeds)) {
            return memo.get(curNeeds);
        }

        // 价格
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += curNeeds.get(i) * price.get(i);
        }
        for (List<Integer> sp : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int need = curNeeds.get(i) - sp.get(i);
                // 不能购买超出购物清单指定数量的物品
                if (need < 0) break;
                nextNeeds.add(need);
            }
            if (nextNeeds.size() == n) {
                res = Math.min(res, dfs(nextNeeds) + sp.get(n));
            }
        }
        memo.put(curNeeds, res);
        return res;
    }
}
/*
638. 大礼包
https://leetcode.cn/problems/shopping-offers/

在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
提示：
n == price.length
n == needs.length
1 <= n <= 6
0 <= price[i] <= 10
0 <= needs[i] <= 10
1 <= special.length <= 100
special[i].length == n + 1
0 <= special[i][j] <= 50

记忆化搜索
时间复杂度 O(nk * m^n)。其中 n = price.size(), k = special.size(), m = needs[i],
空间复杂度 O(m^n)。
 */