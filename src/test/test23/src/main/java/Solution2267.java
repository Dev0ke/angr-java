import java.util.LinkedList;
import java.util.Queue;

public class Solution2267 {
    public boolean hasValidPath(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        if (grid[0][0] == ')' || grid[M - 1][N - 1] == '(') {
            return false;
        }
        // 剪枝
        if ((M + N + 1) % 2 != 0) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        // 剪枝
        boolean[][][] visited = new boolean[M][N][M + N];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                int curM = cur.x;
                int curN = cur.y;
                int stack = cur.stack;
                if (curM == M - 1 && curN == N - 1 && stack == 0) {
                    return true;
                }
                if (stack < 0) {
                    continue;
                }

                // 向 下
                if (curM + 1 < M) {
                    int nextM = curM + 1;
                    int nextStack = stack + (grid[nextM][curN] == '(' ? 1 : -1);
                    if (nextStack >= 0 && !visited[nextM][curN][nextStack]) {
                        visited[nextM][curN][nextStack] = true;
                        queue.add(new Node(nextM, curN, nextStack));
                    }
                }
                // 向 右
                if (curN + 1 < N) {
                    int nextN = curN + 1;
                    int nextStack = stack + (grid[curM][nextN] == '(' ? 1 : -1);
                    if (nextStack >= 0 && !visited[curM][nextN][nextStack]) {
                        visited[curM][nextN][nextStack] = true;
                        queue.add(new Node(curM, nextN, nextStack));
                    }
                }
            }
        }
        return false;
    }

    private static class Node {
        int x;
        int y;
        int stack;

        public Node(int x, int y, int stack) {
            this.x = x;
            this.y = y;
            this.stack = stack;
        }
    }
}
/*
2267. 检查是否有合法括号字符串路径
https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/

第 292 场周赛 T4。

一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。
- 字符串是 () 。
- 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。
- 字符串可以表示为 (A) ，其中 A 是合法括号序列。
给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径：
- 路径开始于左上角格子 (0, 0) 。
- 路径结束于右下角格子 (m - 1, n - 1) 。
- 路径每次只会向 下 或者向 右 移动。
- 路径经过的格子组成的括号字符串是 合法 的。
如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] 要么是 '(' ，要么是 ')' 。

bfs + 括号配对
 */