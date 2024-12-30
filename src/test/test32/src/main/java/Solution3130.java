import java.util.Arrays;

public class Solution3130 {
    private static final int MOD = (int) (1e9 + 7);
    private int limit;
    private long[][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new long[zero + 1][one + 1][2];
        for (int a = 0; a < zero + 1; a++) {
            for (int b = 0; b < one + 1; b++) {
                Arrays.fill(memo[a][b], -1);
            }
        }

        long ans = dfs(zero, one, 0) + dfs(zero, one, 1);
        return (int) (ans % MOD);
    }

    // 表示用 i 个 0，j 个 1 构造稳定二进制数组的方案数，其中第 i+j 个位置要填 k
    // dfs(i-1,j,1) + dfs(i-1,j,0) - dfs(i-1-limit,j,1)
    private long dfs(int i, int j, int k) {
        if (i == 0) {
            return k == 1 && j <= limit ? 1 : 0;
        }
        if (j == 0) {
            return k == 0 && i <= limit ? 1 : 0;
        }
        if (memo[i][j][k] != -1) return memo[i][j][k];

        long res;
        if (k == 0) {
            res = dfs(i - 1, j, 1) + dfs(i - 1, j, 0) - (i - 1 - limit >= 0 ? dfs(i - 1 - limit, j, 1) : 0);
        } else {
            res = dfs(i, j - 1, 0) + dfs(i, j - 1, 1) - (j - 1 - limit >= 0 ? dfs(i, j - 1 - limit, 0) : 0);
        }
        res = (res % MOD + MOD) % MOD;
        return memo[i][j][k] = res;
    }
}
/*
3130. 找出所有稳定的二进制数组 II
https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-ii/description/

第 129 场双周赛 T4。

给你 3 个正整数 zero ，one 和 limit 。
一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
- 0 在 arr 中出现次数 恰好 为 zero 。
- 1 在 arr 中出现次数 恰好 为 one 。
- arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
请你返回 稳定 二进制数组的 总 数目。
由于答案可能很大，将它对 10^9 + 7 取余 后返回。
提示：
1 <= zero, one, limit <= 1000

记忆化搜索。感觉状态定义比较难想。。
时间复杂度 O(zero * one)。
rating 2810 (clist.by)
相似题目: 2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/
 */