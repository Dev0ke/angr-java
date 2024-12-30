public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int cntL = 0, cntR = 0, cnt_ = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') cntL++;
            else if (ch == 'R') cntR++;
            else cnt_++;
        }
        return Math.abs(cntL - cntR) + cnt_;
    }
}
/*
2833. 距离原点最远的点
https://leetcode.cn/problems/furthest-point-from-origin/

第 360 场周赛 T1。

给你一个长度为 n 的字符串 moves ，该字符串仅由字符 'L'、'R' 和 '_' 组成。字符串表示你在一条原点为 0 的数轴上的若干次移动。
你的初始位置就在原点（0），第 i 次移动过程中，你可以根据对应字符选择移动方向：
- 如果 moves[i] = 'L' 或 moves[i] = '_' ，可以选择向左移动一个单位距离
- 如果 moves[i] = 'R' 或 moves[i] = '_' ，可以选择向右移动一个单位距离
移动 n 次之后，请你找出可以到达的距离原点 最远 的点，并返回 从原点到这一点的距离 。
提示：
1 <= moves.length == n <= 50
moves 仅由字符 'L'、'R' 和 '_' 组成

贪心。
 */