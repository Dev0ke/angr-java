import java.util.Arrays;

public class Solution935 {
    private static final int MOD = (int) (1e9 + 7);
    static final int[][] MOVES = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    private int n;
    private long[][] memo;

    public int knightDialer(int n) {
        this.n = n;
        memo = new long[n][10];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dfs(0, i);
        }
        return (int) (ans % MOD);
    }

    private long dfs(int i, int num) {
        if (i == n - 1) return 1;
        if (memo[i][num] != -1) return memo[i][num];
        long res = 0;
        for (int x : MOVES[num]) {
            res += dfs(i + 1, x);
        }
        return memo[i][num] = res % MOD;
    }
}
/*
935. 骑士拨号器
https://leetcode.cn/problems/knight-dialer/description/

象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
象棋骑士可能的移动方式如下图所示:
我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
因为答案可能很大，所以输出答案模 10^9 + 7.
提示：
1 <= n <= 5000

记忆化搜索。
时间复杂度 O(n)。其中常数为 10.
 */