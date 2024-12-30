import java.util.ArrayList;
import java.util.List;

public class Solution1222 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int n = 8;

        boolean[][] queen = new boolean[n][n];
        for (int[] p : queens) {
            queen[p[0]][p[1]] = true;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] dir : DIRECTIONS8) {
            for (int i = 1; i <= n; i++) {
                int nx = king[0] + dir[0] * i;
                int ny = king[1] + dir[1] * i;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (queen[nx][ny]) {
                        ans.add(List.of(nx, ny));
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
/*
1222. 可以攻击国王的皇后
https://leetcode.cn/problems/queens-that-can-attack-the-king/

在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
提示：
1 <= queens.length <= 63
queens[i].length == 2
0 <= queens[i][j] < 8
king.length == 2
0 <= king[0], king[1] < 8
一个棋盘格上最多只能放置一枚棋子。

8 个方向上枚举。
时间复杂度 O(1)
 */