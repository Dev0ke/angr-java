public class Solution2056 {
    // 后 queen = 车 rook（前 4） + 象 bishop（后 4）
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private String[] pieces;
    private int[][] positions;
    private int[][][] board;

    public int countCombinations(String[] pieces, int[][] positions) {
        this.pieces = pieces;
        this.positions = positions;
        int n = pieces.length;
        board = new int[n][8][8];
        return dfs(0);
    }

    // 第 i 个棋子
    private int dfs(int i) {
        if (i == pieces.length) {
            return 1;
        }

        int res = 0;
        int x = positions[i][0] - 1, y = positions[i][1] - 1;

        for (int d = 0; d < 8; d++) {
            if (pieces[i].equals("bishop") && d < 4) continue;
            if (pieces[i].equals("rook") && d >= 4) continue;

            boolean block = false;
            // 因为起始位置在8个方向中只能考虑一次，所以我们用res作为旗帜，只有第一次移动时会考虑停留在初始位置
            for (int step = (res == 0 ? 1 : 2); !block; step++) {
                int nx = x + (step - 1) * DIRECTIONS8[d][0];
                int ny = y + (step - 1) * DIRECTIONS8[d][1];

                // 必须剪枝，否则超时
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                    break;
                }
                boolean canStop = true;
                // 检查前 i-1 个棋子的在当前位置的情况，判断我们是否可以选择停留或继续前进
                for (int j = 0; j < i; j++) {
                    // 只有当前 i-1 个棋子都没有停留，并且没有棋子会在之后经过，第 i 个棋子才可以在当前位置停留
                    canStop &= board[j][nx][ny] >= 0 && board[j][nx][ny] < step;
                    // 如果前 i-1 个棋子在当前时间之前停留在此位置，或者有棋子同时经过这里，第 i 个棋子就不可以继续前进了
                    block |= board[j][nx][ny] < 0 && -board[j][nx][ny] <= step;
                    block |= board[j][nx][ny] == step;
                }

                if (canStop) {
                    // 如果可以停留 用负数标记当前位置为棋子 i 的停留位
                    board[i][nx][ny] = -step;
                    res += dfs(i + 1);
                }
                // 选择继续移动
                board[i][nx][ny] = step;
            }
            // 当前方向考虑结束，清空棋盘，考虑下一个方向
            board[i] = new int[8][8];
        }
        return res;
    }
}
/*
2056. 棋盘上有效移动组合的数目
https://leetcode.cn/problems/number-of-valid-move-combinations-on-chessboard/

第 64 场双周赛 T4。

有一个 8 x 8 的棋盘，它包含 n 个棋子（棋子包括车，后和象三种）。给你一个长度为 n 的字符串数组 pieces ，其中 pieces[i] 表示第 i 个棋子的类型（车，后或象）。除此以外，还给你一个长度为 n 的二维整数数组 positions ，其中 positions[i] = [ri, ci] 表示第 i 个棋子现在在棋盘上的位置为 (ri, ci) ，棋盘下标从 1 开始。
棋盘上每个棋子都可以移动 至多一次 。每个棋子的移动中，首先选择移动的 方向 ，然后选择 移动的步数 ，同时你要确保移动过程中棋子不能移到棋盘以外的地方。棋子需按照以下规则移动：
- 车可以 水平或者竖直 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1) 或者 (r, c-1) 移动。
- 后可以 水平竖直或者斜对角 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1)，(r, c-1)，(r+1, c+1)，(r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。
- 象可以 斜对角 从 (r, c) 沿着方向 (r+1, c+1)，(r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。
移动组合 包含所有棋子的 移动 。每一秒，每个棋子都沿着它们选择的方向往前移动 一步 ，直到它们到达目标位置。所有棋子从时刻 0 开始移动。如果在某个时刻，两个或者更多棋子占据了同一个格子，那么这个移动组合 不有效 。
请你返回 有效 移动组合的数目。
注意：
- 初始时，不会有两个棋子 在 同一个位置 。
- 有可能在一个移动组合中，有棋子不移动。
- 如果两个棋子 直接相邻 且两个棋子下一秒要互相占据对方的位置，可以将它们在同一秒内 交换位置 。
提示：
n == pieces.length
n == positions.length
1 <= n <= 4
pieces 只包含字符串 "rook" ，"queen" 和 "bishop" 。
棋盘上总共最多只有一个后。
1 <= xi, yi <= 8
每一个 positions[i] 互不相同。

https://leetcode.cn/problems/number-of-valid-move-combinations-on-chessboard/solutions/1245960/bao-li-po-jie-de-si-lu-xiang-jie-fu-java-t437/
 */