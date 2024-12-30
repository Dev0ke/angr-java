import java.util.HashMap;
import java.util.Map;

public class Solution3154 {
    private int k;
    private Map<String, Integer> memo;

    public int waysToReachStair(int k) {
        this.k = k;
        memo = new HashMap<>();
        return dfs(1, 0, 0);
    }

    // 当前位于第 i 个台阶。已经使用了 j 次操作二。一个布尔值，表示上一次操作是否使用了操作一。
    private int dfs(int i, int j, int preDown) {
        if (i > k + 1) return 0;
        String key = i + ":" + j + ":" + preDown;
        if (memo.containsKey(key)) return memo.get(key);
        int res = i == k ? 1 : 0;
        res += dfs(i + (1 << j), j + 1, 0);
        if (preDown == 0) {
            res += dfs(i - 1, j, 1);
        }
        memo.put(key, res);
        return res;
    }
}
/*
3154. 到达第 K 级台阶的方案数
https://leetcode.cn/problems/find-number-of-ways-to-reach-the-k-th-stair/description/

第 398 场周赛 T4。

给你有一个 非负 整数 k 。有一个无限长度的台阶，最低 一层编号为 0 。
虎老师有一个整数 jump ，一开始值为 0 。虎老师从台阶 1 开始，虎老师可以使用 任意 次操作，目标是到达第 k 级台阶。假设虎老师位于台阶 i ，一次 操作 中，虎老师可以：
- 向下走一级到 i - 1 ，但该操作 不能 连续使用，如果在台阶第 0 级也不能使用。
- 向上走到台阶 i + 2^jump 处，然后 jump 变为 jump + 1 。
请你返回虎老师到达台阶 k 处的总方案数。
注意 ，虎老师可能到达台阶 k 处后，通过一些操作重新回到台阶 k 处，这视为不同的方案。
提示：
0 <= k <= 10^9

记忆化搜索。
时间复杂度 O(log^2 k)
 */