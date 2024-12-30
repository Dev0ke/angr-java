import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1387 {
    private Map<Integer, Integer> memo;

    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(i);
        }
        memo = new HashMap<>();
        list.sort((u, v) -> {
            int fu = getF(u), fv = getF(v);
            if (fu == fv) return Integer.compare(u, v);
            return Integer.compare(fu, fv);
        });
        return list.get(k - 1);
    }

    private int getF(int x) {
        if (memo.containsKey(x)) return memo.get(x);
        int res;
        if (x == 1) res = 0;
        else if ((x & 1) != 0) res = getF(x * 3 + 1) + 1;
        else res = getF(x / 2) + 1;
        memo.put(x, res);
        return res;
    }
}
/*
1387. 将整数按权重排序
https://leetcode.cn/problems/sort-integers-by-the-power-value/description/

我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
- 如果 x 是偶数，那么 x = x / 2
- 如果 x 是奇数，那么 x = 3 * x + 1
比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
提示：
1 <= lo <= hi <= 1000
1 <= k <= hi - lo + 1

自定义排序。
求 权值函数 加上记忆化。
在 [1,1000] 中所有 x 求 f(x) 的值的过程中，只可能出现 2228 种 x
时间复杂度 O(2228)。
 */