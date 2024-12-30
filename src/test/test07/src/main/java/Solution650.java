public class Solution650 {
    public int minSteps(int n) {
        // 设 f[i] 表示打印出 i 个 A 的最少操作次数
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
/*
650. 只有两个键的键盘
https://leetcode.cn/problems/2-keys-keyboard/

最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
- Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
- Paste（粘贴）：粘贴 上一次 复制的字符。
给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
提示：
1 <= n <= 1000

动态规划
时间复杂度 O(n·√n)
空间复杂度 O(n)
 */