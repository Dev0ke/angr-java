import java.util.Arrays;

public class Solution1269 {
    private static final long MOD = (long) (1e9 + 7);
    private long[][] memo;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);

        memo = new long[steps + 1][arrLen];
        for (int i = 0; i < steps + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) dfs(steps, arrLen, 0);
    }

    // steps:剩余步数(0~steps) pos:位置(0~arrLen-1)
    private long dfs(int steps, int arrLen, int pos) {
        if (steps == 0) {
            return pos == 0 ? 1 : 0;
        }
        if (memo[steps][pos] != -1) {
            return memo[steps][pos];
        }

        // 原地不动
        long res = dfs(steps - 1, arrLen, pos) % MOD;
        // 向右
        if (pos + 1 < arrLen) {
            res += dfs(steps - 1, arrLen, pos + 1);
            res %= MOD;
        }
        // 向左
        if (pos - 1 >= 0) {
            res += dfs(steps - 1, arrLen, pos - 1);
            res %= MOD;
        }
        memo[steps][pos] = res;
        return res;
    }
}
/*
1269. 停在原地的方案数
https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
提示：
1 <= steps <= 500
1 <= arrLen <= 10^6

记忆化搜索
相似题目: 2400. 恰好移动 k 步到达某一位置的方法数目
https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
 */