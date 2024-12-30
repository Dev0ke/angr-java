import java.util.HashMap;
import java.util.Map;

public class Solution964 {
    private int x;
    private Map<String, Integer> memo;

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        memo = new HashMap<>();
        return dfs(0, target) - 1;
    }

    private int dfs(int i, int target) {
        String key = i + ":" + target;
        if (memo.containsKey(key)) return memo.get(key);

        int res;
        if (target == 0) {
            res = 0;
        } else if (target == 1) {
            res = cost(i);
        } else if (i >= 28) { // 2^28 = 268,435,456 > 2e8
            res = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            int res1 = r * cost(i) + dfs(i + 1, t);
            int res2 = (x - r) * cost(i) + dfs(i + 1, t + 1);
            res = Math.min(res1, res2);
        }
        memo.put(key, res);
        return res;
    }

    // x^e
    // 当 e=0 的时候除外，其价值为 2
    private int cost(int x) {
        return x > 0 ? x : 2;
    }
}
/*
964. 表示数字的最少运算符
https://leetcode.cn/problems/least-operators-to-express-number/description/

给定一个正整数 x，我们将会写出一个形如 x (op1) x (op2) x (op3) x ... 的表达式，其中每个运算符 op1，op2，… 可以是加、减、乘、除（+，-，*，或是 /）之一。例如，对于 x = 3，我们可以写出表达式 3 * 3 / 3 + 3 - 3，该式的值为 3 。
在写这样的表达式时，我们需要遵守下面的惯例：
- 除运算符（/）返回有理数。
- 任何地方都没有括号。
- 我们使用通常的操作顺序：乘法和除法发生在加法和减法之前。
- 不允许使用一元否定运算符（-）。例如，“x - x” 是一个有效的表达式，因为它只使用减法，但是 “-x + x” 不是，因为它使用了否定运算符。
我们希望编写一个能使表达式等于给定的目标值 target 且运算符最少的表达式。返回所用运算符的最少数量。
提示：
2 <= x <= 100
1 <= target <= 2 * 10^8

记忆化搜索。
时间复杂度 O(log_{x}^{target})。
 */