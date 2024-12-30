import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution773 {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int M = 2, N = 3;
    static final long FINAL = 123450;

    public int slidingPuzzle(int[][] board) {
        long n = 0;
        for (int[] row : board) {
            for (int x : row) {
                n = n * 10 + x;
            }
        }
        Queue<Long> q = new ArrayDeque<>();
        Map<Long, Integer> mp = new HashMap<>();
        q.add(n);
        mp.put(n, 0);
        while (!q.isEmpty()) {
            long x = q.remove();
            int[][] c = new int[2][3];
            int f = 0, g = 0;
            long y = x;
            if (x == FINAL) break;
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    c[i][j] = (int) (y % 10);
                    y /= 10;
                    if (c[i][j] == 0) {
                        f = i;
                        g = j;
                    }
                }
            }
            for (int[] d : DIRECTIONS) {
                int nx = f + d[0];
                int ny = g + d[1];
                long ns = 0;
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    swap(c, nx, ny, f, g);
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < N; j++) {
                            ns = ns * 10 + c[i][j];
                        }
                    }
                    if (!mp.containsKey(ns)) {
                        mp.put(ns, mp.get(x) + 1);
                        q.add(ns);
                    }
                    swap(c, nx, ny, f, g);
                }
            }
        }
        return mp.getOrDefault(FINAL, -1);
    }

    private void swap(int[][] c, int x0, int y0, int x1, int y1) {
        int tmp = c[x0][y0];
        c[x0][y0] = c[x1][y1];
        c[x1][y1] = tmp;
    }
}
/*
773. 滑动谜题
https://leetcode.cn/problems/sliding-puzzle/description/

在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
提示：
board.length == 2
board[i].length == 3
0 <= board[i][j] <= 5
board[i][j] 中每个值都 不同

八数码问题。
相似题目: P1379 八数码难题
https://www.luogu.com.cn/problem/P1379
 */