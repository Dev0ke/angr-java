public class Solution3001 {
    // 后 queen = 车 rook（前 4） + 象 bishop（后 4）
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 走 1~7 步
        for (int i = 0; i < 4; i++) {
            int[] di = DIRECTIONS8[i];
            for (int j = 1; j < 8; j++) {
                if (a + di[0] * j == c && b + di[1] * j == d) {
                    break;
                }
                if (a + di[0] * j == e && b + di[1] * j == f) {
                    return 1;
                }
            }
        }

        for (int i = 4; i < 8; i++) {
            int[] di = DIRECTIONS8[i];
            for (int j = 1; j < 8; j++) {
                if (c + di[0] * j == a && d + di[1] * j == b) {
                    break;
                }
                if (c + di[0] * j == e && d + di[1] * j == f) {
                    return 1;
                }
            }
        }

        return 2;
    }
}
/*
3001. 捕获黑皇后需要的最少移动次数
https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/description/

第 379 场周赛 T2。

现有一个下标从 0 开始的 8 x 8 棋盘，上面有 3 枚棋子。
给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
- (a, b) 表示白色车的位置。
- (c, d) 表示白色象的位置。
- (e, f) 表示黑皇后的位置。
假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
请注意：
- 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
- 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
- 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
- 皇后不能移动。
提示：
1 <= a, b, c, d, e, f <= 8
两枚棋子不会同时出现在同一个格子上。

脑筋急转弯。
答案要么是 1 要么是 2。如果能直接攻击到，那么是 1，否则把挡路的挪开，再攻击，答案是 2。
时间复杂度 O(1)
 */