public class Solution375 {
    public int getMoneyAmount(int n) {
        // f[i][j] 表示在范围 [i,j] 内确保胜利的最少金额
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
/*
$375. 猜数字大小 II
https://leetcode.cn/problems/guess-number-higher-or-lower-ii/

我们正在玩一个猜数游戏，游戏规则如下：
1.我从 1 到 n 之间选择一个数字。
2.你来猜我选了哪个数字。
3.如果你猜到正确的数字，就会 赢得游戏 。
4.如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
5.每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
提示：
1 <= n <= 200

动态规划
时间复杂度 O(n^3)
 */