import java.util.Arrays;

public class Solution3129 {
    private static final int MOD = (int) (1e9 + 7);
    private int limit;
    private long[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new long[2][limit + 1][zero + 1][one + 1];
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < limit + 1; b++) {
                for (int c = 0; c < zero + 1; c++) {
                    Arrays.fill(memo[a][b][c], -1);
                }
            }
        }
        long ans = dfs(0, 1, zero - 1, one) + dfs(1, 1, zero, one - 1);
        return (int) (ans % MOD);
    }

    // pre: 0/1
    private long dfs(int pre, int lim, int zero, int one) {
        if (zero + one == 0) return 1;
        if (memo[pre][lim][zero][one] != -1) return memo[pre][lim][zero][one];
        long res = 0;
        if (lim + 1 <= limit) {
            // 可切可不切
            if (pre == 0) {
                if (zero > 0) res += dfs(0, lim + 1, zero - 1, one);
                if (one > 0) res += dfs(1, 1, zero, one - 1);
            } else {
                if (zero > 0) res += dfs(0, 1, zero - 1, one);
                if (one > 0) res += dfs(1, lim + 1, zero, one - 1);
            }
        } else {
            // 必须切换
            if (pre == 0) {
                if (one > 0) res += dfs(1, 1, zero, one - 1);
            } else {
                if (zero > 0) res += dfs(0, 1, zero - 1, one);
            }
        }
        return memo[pre][lim][zero][one] = res % MOD;
    }
}
/*
3129. 找出所有稳定的二进制数组 I
https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-i/description/

第 129 场双周赛 T3。

给你 3 个正整数 zero ，one 和 limit 。
一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
- 0 在 arr 中出现次数 恰好 为 zero 。
- 1 在 arr 中出现次数 恰好 为 one 。
- arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
请你返回 稳定 二进制数组的 总 数目。
由于答案可能很大，将它对 10^9 + 7 取余 后返回。
提示：
1 <= zero, one, limit <= 200

记忆化搜索。
时间复杂度 O(zero * one * limit)。
本题还有组合数学的解法。
相似题目: 2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/
 */