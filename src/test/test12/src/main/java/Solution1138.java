public class Solution1138 {
    public String alphabetBoardPath(String target) {
        int r = 0, c = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int nr = (ch - 'a') / 5;
            int nc = (ch - 'a') % 5;
            // 优先 向上走 向左走
            if (nr < r) {
                stringBuilder.append("U".repeat(r - nr));
            }
            if (nc < c) {
                stringBuilder.append("L".repeat(c - nc));
            }
            if (nr > r) {
                stringBuilder.append("D".repeat(nr - r));
            }
            if (nc > c) {
                stringBuilder.append("R".repeat(nc - c));
            }
            stringBuilder.append("!");
            r = nr;
            c = nc;
        }
        return stringBuilder.toString();
    }
}
/*
1138. 字母板上的路径
https://leetcode.cn/problems/alphabet-board-path/

我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
我们可以按下面的指令规则行动：
- 如果方格存在，'U' 意味着将我们的位置上移一行；
- 如果方格存在，'D' 意味着将我们的位置下移一行；
- 如果方格存在，'L' 意味着将我们的位置左移一列；
- 如果方格存在，'R' 意味着将我们的位置右移一列；
- '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
（注意，字母板上只存在有字母的位置。）
返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
提示：
1 <= target.length <= 100
target 仅含有小写英文字母。

模拟。为了保证含有字符 'z' 时能够正常移动，每次移动时优先保证选择上移和左移。
时间复杂度 O(n)
空间复杂度 O(1)
 */