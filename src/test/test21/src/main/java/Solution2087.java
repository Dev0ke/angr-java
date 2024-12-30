public class Solution2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startRow = startPos[0];
        int startCol = startPos[1];
        int homeRow = homePos[0];
        int homeCol = homePos[1];
        // 行
        int cntRow = 0;
        if (startRow < homeRow) {
            for (int i = startRow + 1; i <= homeRow; i++) {
                cntRow += rowCosts[i];
            }
        } else if (startRow > homeRow) {
            for (int i = startRow - 1; i >= homeRow; i--) {
                cntRow += rowCosts[i];
            }
        }
        // 列
        int cntCol = 0;
        if (startCol < homeCol) {
            for (int i = startCol + 1; i <= homeCol; i++) {
                cntCol += colCosts[i];
            }
        } else if (startCol > homeCol) {
            for (int i = startCol - 1; i >= homeCol; i--) {
                cntCol += colCosts[i];
            }
        }
        return cntRow + cntCol;
    }
}
/*
2087. 网格图中机器人回家的最小代价
https://leetcode.cn/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

第 66 场双周赛 T3。

给你一个 m x n 的网格图，其中 (0, 0) 是最左上角的格子，(m - 1, n - 1) 是最右下角的格子。
给你一个整数数组 startPos ，startPos = [startrow, startcol] 表示 初始 有一个 机器人 在格子 (startrow, startcol) 处。
同时给你一个整数数组 homePos ，homePos = [homerow, homecol] 表示机器人的 家 在格子 (homerow, homecol) 处。
机器人需要回家。每一步它可以往四个方向移动：上，下，左，右，同时机器人不能移出边界。每一步移动都有一定代价。
再给你两个下标从 0 开始的额整数数组：长度为 m 的数组 rowCosts  和长度为 n 的数组 colCosts 。
如果机器人往 上 或者往 下 移动到第 r 行 的格子，那么代价为 rowCosts[r] 。
如果机器人往 左 或者往 右 移动到第 c 列 的格子，那么代价为 colCosts[c] 。
请你返回机器人回家需要的 最小总代价 。

咋眼一看，以为是 dp 或者 BFS/DFS。接着发现跟移动的先后顺序无关，直接累加即可。
 */