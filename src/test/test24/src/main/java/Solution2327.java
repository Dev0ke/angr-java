public class Solution2327 {
    private static final int MOD = 1000000007;

    // 时间复杂度 O(n^2)
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // dp[i][0] 第 i 天，知道秘密，不能分享
        // dp[i][1] 第 i 天，知道秘密，可以分享
        int[][] dp = new int[n + 1][2];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            // [i+1, i+delay-1] 人数累加入 dp[j][0]
            for (int j = i; j < Math.min(i + delay, n + 1); j++) {
                dp[j][0] = (dp[j][0] + dp[i][1]) % MOD;
            }
            // [i+delay, i+forget-1] 人数累加入 dp[j][1]
            for (int j = i + delay; j < Math.min(i + forget, n + 1); j++) {
                dp[j][1] = (dp[j][1] + dp[i][1]) % MOD;
            }
        }
        return (dp[n][0] + dp[n][1]) % MOD;
    }

    // 时间复杂度 O(n^2) 压缩为一维数组
    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        // dp[i][0] 第 i 天，知道秘密，不能分享
        // dp[i][1] 第 i 天，知道秘密，可以分享
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int cnt0 = 0;
        for (int i = 1; i <= n; i++) {
            // [i+1, i+delay-1] 人数累加入 dp[j][0]
            if (i + delay > n) {
                cnt0 = (cnt0 + dp[i]) % MOD;
            }
            // [i+delay, i+forget-1] 人数累加入 dp[j][1]
            for (int j = i + delay; j < Math.min(i + forget, n + 1); j++) {
                dp[j] = (dp[j] + dp[i]) % MOD;
            }
        }
        return (cnt0 + dp[n]) % MOD;
    }
}
/*
2327. 知道秘密的人数
https://leetcode.cn/problems/number-of-people-aware-of-a-secret/

第 300 场周赛 T3。

在第 1 天，有一个人发现了一个秘密。
给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。
同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 10^9 + 7 取余 后返回。
提示：
2 <= n <= 1000
1 <= delay < forget <= n
 */