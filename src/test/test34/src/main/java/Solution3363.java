import java.util.Arrays;

public class Solution3363 {
    private int[][] fruits;
    private int n;
    private int[][] memo;

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        this.fruits = fruits;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i]; // 从 (0, 0) 出发的小朋友，对角线必选
        }

        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        ans += dfs(n - 2, n - 1); // 从 (0, n - 1) 出发的小朋友
        // 把下三角形中的数据填到上三角形中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                fruits[j][i] = fruits[i][j];
            }
        }
        // 记得重置 memo
        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return ans + dfs(n - 2, n - 1);
    }

    private int dfs(int i, int j) {
        if (j < n - 1 - i || j >= n) return Integer.MIN_VALUE;
        if (i == 0) return fruits[i][j];
        if (memo[i][j] != -1) return memo[i][j];
        int res = Math.max(Math.max(dfs(i - 1, j - 1), dfs(i - 1, j)),
                dfs(i - 1, j + 1)) + fruits[i][j];
        return memo[i][j] = res;
    }
}
/*
3363. 最多可收集的水果数目
https://leetcode.cn/problems/find-the-maximum-number-of-fruits-collected/description/

第 144 场双周赛 T4。

有一个游戏，游戏由 n x n 个房间网格状排布组成。
给你一个大小为 n x n 的二位整数数组 fruits ，其中 fruits[i][j] 表示房间 (i, j) 中的水果数目。有三个小朋友 一开始 分别从角落房间 (0, 0) ，(0, n - 1) 和 (n - 1, 0) 出发。
每一位小朋友都会 恰好 移动 n - 1 次，并到达房间 (n - 1, n - 1) ：
- 从 (0, 0) 出发的小朋友每次移动从房间 (i, j) 出发，可以到达 (i + 1, j + 1) ，(i + 1, j) 和 (i, j + 1) 房间之一（如果存在）。
- 从 (0, n - 1) 出发的小朋友每次移动从房间 (i, j) 出发，可以到达房间 (i + 1, j - 1) ，(i + 1, j) 和 (i + 1, j + 1) 房间之一（如果存在）。
- 从 (n - 1, 0) 出发的小朋友每次移动从房间 (i, j) 出发，可以到达房间 (i - 1, j + 1) ，(i, j + 1) 和 (i + 1, j + 1) 房间之一（如果存在）。
当一个小朋友到达一个房间时，会把这个房间里所有的水果都收集起来。如果有两个或者更多小朋友进入同一个房间，只有一个小朋友能收集这个房间的水果。当小朋友离开一个房间时，这个房间里不会再有水果。
请你返回三个小朋友总共 最多 可以收集多少个水果。
提示：
2 <= n == fruits.length == fruits[i].length <= 1000
0 <= fruits[i][j] <= 1000

诈骗题。脑筋急转弯。
一般这种题 需要 n^3 的动态规划。但是本题 n = 1000。
注意到恰好移动 n-1 次，实际小朋友A 只能沿对角线走，小朋友B 只能在上半区走，小朋友C 只能在下半区走。
时间复杂度 O(n^2)。
rating 2405 (clist.by)
 */