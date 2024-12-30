import java.util.HashMap;
import java.util.Map;

public class Solution1553 {
    private Map<Integer, Integer> memo;

    public int minDays(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int res1 = dfs(n / 2) + n % 2 + 1;
        int res2 = dfs(n / 3) + n % 3 + 1;
        int res = Math.min(res1, res2);
        memo.put(n, res);
        return res;
    }
}
/*
1553. 吃掉 N 个橘子的最少天数
https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/description/

厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
- 吃掉一个橘子。
- 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
- 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
每天你只能从以上 3 种方案中选择一种方案。
请你返回吃掉所有 n 个橘子的最少天数。
提示：
1 <= n <= 2*10^9

记忆化搜索。
时间复杂度 O(log^2(n))
 */