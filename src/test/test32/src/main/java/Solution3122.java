import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3122 {
    private int m, n;
    private List<Node[]> cntList;
    private int[][] memo;

    public int minimumOperations(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        cntList = new ArrayList<>();
        Node[] cnt0 = new Node[3];
        for (int i = 0; i < 3; i++) {
            cnt0[i] = new Node(10, m);
        }
        cntList.add(cnt0);
        for (int j = 0; j < n; j++) {
            Node[] cnt = new Node[11];
            for (int i = 0; i < 11; i++) {
                cnt[i] = new Node(i, 0);
            }
            for (int[] row : grid) {
                cnt[row[j]].cnt++;
            }
            Arrays.sort(cnt, (o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
            cntList.add(cnt);
        }

        memo = new int[n + 1][11];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(1, 10);
    }

    private int dfs(int i, int pre) {
        if (i == n + 1) return 0;

        if (memo[i][pre] != -1) return memo[i][pre];
        int res = Integer.MAX_VALUE;
        Node[] cnt = cntList.get(i);
        // 取 top3 即可
        for (int k = 0; k < 3; k++) {
            if (cnt[k].num != pre) {
                res = Math.min(res, m - cnt[k].cnt + dfs(i + 1, cnt[k].num));
            }
        }
        return memo[i][pre] = res;
    }

    private static class Node {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
/*
3122. 使矩阵满足条件的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-satisfy-conditions/description/

第 394 场周赛 T3。

给你一个大小为 m x n 的二维矩形 grid 。每次 操作 中，你可以将 任一 格子的值修改为 任意 非负整数。完成所有操作后，你需要确保每个格子 grid[i][j] 的值满足：
- 如果下面相邻格子存在的话，它们的值相等，也就是 grid[i][j] == grid[i + 1][j]（如果存在）。
- 如果右边相邻格子存在的话，它们的值不相等，也就是 grid[i][j] != grid[i][j + 1]（如果存在）。
请你返回需要的 最少 操作数目。
提示：
1 <= n, m <= 1000
0 <= grid[i][j] <= 9

记忆化搜索。取 top3 频次对应的数字来做 DP 即可。
时间复杂度 O(mn + nU^2)。本题 U = 10.
 */