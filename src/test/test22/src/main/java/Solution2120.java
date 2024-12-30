public class Solution2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        // m == s.length
        int m = s.length();
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            int curM = startPos[0];
            int curN = startPos[1];

            for (int j = i; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == 'L') {
                    curN -= 1;
                } else if (ch == 'R') {
                    curN += 1;
                } else if (ch == 'U') {
                    curM -= 1;
                } else {
                    curM += 1;
                }

                // 不会移动到网格外
                if (curM >= 0 && curM < n && curN >= 0 && curN < n) {
                    cnt++;
                    if (j == m - 1) {
                        res[i] = cnt;
                        break;
                    }
                } else {
                    res[i] = cnt;
                    break;
                }
            }
        }
        return res;
    }
}
/*
2120. 执行所有后缀指令
https://leetcode.cn/problems/execution-of-all-suffix-instructions-staying-in-a-grid/

第 273 场周赛 T2。

现有一个 n x n 大小的网格，左上角单元格坐标 (0, 0) ，右下角单元格坐标 (n - 1, n - 1) 。给你整数 n 和一个整数数组 startPos ，
其中 startPos = [startrow, startcol] 表示机器人最开始在坐标为 (startrow, startcol) 的单元格上。
另给你一个长度为 m 、下标从 0 开始的字符串 s ，其中 s[i] 是对机器人的第 i 条指令：'L'（向左移动），'R'（向右移动），'U'（向上移动）和 'D'（向下移动）。
机器人可以从 s 中的任一第 i 条指令开始执行。它将会逐条执行指令直到 s 的末尾，但在满足下述条件之一时，机器人将会停止：
- 下一条指令将会导致机器人移动到网格外。
- 没有指令可以执行。
返回一个长度为 m 的数组 answer ，其中 answer[i] 是机器人从第 i 条指令 开始 ，可以执行的 指令数目 。
提示：
m == s.length
1 <= n, m <= 500
startPos.length == 2
0 <= startrow, startcol < n
s 由 'L'、'R'、'U' 和 'D' 组成

范围 500^500 = 2.5 * 10^5
BFS 逐一模拟即可。
 */