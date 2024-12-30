public class Solution3257 {
    int m, n;
    int[][] board;
    int[][] top3; // val, j

    public long maximumValueSum(int[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;

        // 前后缀分解
        top3 = new int[3][2];
        for (int i = 0; i < 3; i++) top3[i][0] = Integer.MIN_VALUE;
        int[][][] pre = new int[m][3][2];
        for (int i = 0; i < m; i++) {
            update(i);
            for (int j = 0; j < 3; j++) pre[i][j] = top3[j].clone();
        }

        for (int i = 0; i < 3; i++) top3[i][0] = Integer.MIN_VALUE;
        int[][][] suf = new int[m][3][2];
        for (int i = m - 1; i >= 0; i--) {
            update(i);
            for (int j = 0; j < 3; j++) suf[i][j] = top3[j].clone();
        }

        long ans = Long.MIN_VALUE;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 0; j < n; j++) { // 第 2 个车
                for (int[] a : pre[i - 1]) { // 第 1 个车
                    for (int[] c : suf[i + 1]) { // 第 3 个车
                        if (a[1] != j && c[1] != j && a[1] != c[1]) { // 没有同列的车
                            ans = Math.max(ans, (long) a[0] + board[i][j] + c[0]);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void update(int i) {
        int[] row = board[i];
        for (int j = 0; j < n; j++) {
            int x = row[j];
            if (x > top3[0][0]) {
                if (top3[0][1] != j) { // 如果相等，仅更新最大
                    if (top3[1][1] != j) { // 如果相等，仅更新最大和次大
                        top3[2] = top3[1];
                    }
                    top3[1] = top3[0];
                }
                top3[0] = new int[]{x, j};
            } else if (j != top3[0][1] && x > top3[1][0]) {
                if (top3[1][1] != j) { // 如果相等，仅更新次大
                    top3[2] = top3[1];
                }
                top3[1] = new int[]{x, j};
            } else if (j != top3[0][1] && j != top3[1][1] && x > top3[2][0]) {
                top3[2] = new int[]{x, j};
            }
        }
    }
}
/*
3257. 放三个车的价值之和最大 II
https://leetcode.cn/problems/maximum-value-sum-by-placing-three-rooks-ii/description/

第 137 场双周赛 T4。

给你一个 m x n 的二维整数数组 board ，它表示一个国际象棋棋盘，其中 board[i][j] 表示格子 (i, j) 的 价值 。
处于 同一行 或者 同一列 车会互相 攻击 。你需要在棋盘上放三个车，确保它们两两之间都 无法互相攻击 。
请你返回满足上述条件下，三个车所在格子 值 之和 最大 为多少。
提示：
3 <= m == board.length <= 500
3 <= n == board[i].length <= 500
-10^9 <= board[i][j] <= 10^9

枚举中间的数，前后缀分解。
时间复杂度 O(mn)。
rating 2498 (clist.by)
相似题目: D. Three Activities
https://codeforces.com/contest/1914/problem/D
 */