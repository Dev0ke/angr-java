public class Solution36 {
    private static final int BOX_LEN = 3;
    private static final int LEN = BOX_LEN * BOX_LEN;

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[LEN][LEN];
        int[][] columns = new int[LEN][LEN];
        int[][][] boxes = new int[BOX_LEN][BOX_LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int idx = ch - '0' - 1;
                    rows[i][idx]++;
                    columns[j][idx]++;
                    boxes[i / 3][j / 3][idx]++;
                    if (rows[i][idx] > 1 || columns[j][idx] > 1 || boxes[i / 3][j / 3][idx] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*
36. 有效的数独
https://leetcode.cn/problems/valid-sudoku/

请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
- 数字 1-9 在每一行只能出现一次。
- 数字 1-9 在每一列只能出现一次。
- 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
注意：
- 一个有效的数独（部分已被填充）不一定是可解的。
- 只需要根据以上规则，验证已经填入的数字是否有效即可。
- 空白格用 '.' 表示。
提示：
board.length == 9
board[i].length == 9
board[i][j] 是一位数字（1-9）或者 '.'

模拟。
 */