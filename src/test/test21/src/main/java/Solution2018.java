public class Solution2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int k = word.length();

        // 遍历行
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    continue;
                }
                int j0 = j;
                boolean ok1 = true;
                boolean ok2 = true;
                for (; j < n && board[i][j] != '#'; j++) {
                    // 正序匹配 word
                    if (j - j0 >= k || board[i][j] != ' ' && board[i][j] != word.charAt(j - j0)) {
                        ok1 = false;
                    }
                    // 倒序匹配 word
                    if (j - j0 >= k || board[i][j] != ' ' && board[i][j] != word.charAt(k - 1 - (j - j0))) {
                        ok2 = false;
                    }
                }
                if ((ok1 || ok2) && j - j0 == k) {
                    return true;
                }
            }
        }

        // 遍历列
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (board[i][j] == '#') {
                    continue;
                }
                int i0 = i;
                boolean ok1 = true;
                boolean ok2 = true;
                for (; i < m && board[i][j] != '#'; i++) {
                    // 正序匹配 word
                    if (i - i0 >= k || board[i][j] != ' ' && board[i][j] != word.charAt(i - i0)) {
                        ok1 = false;
                    }
                    // 倒序匹配 word
                    if (i - i0 >= k || board[i][j] != ' ' && board[i][j] != word.charAt(k - 1 - (i - i0))) {
                        ok2 = false;
                    }
                }
                if ((ok1 || ok2) && i - i0 == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
2018. 判断单词是否能放入填字游戏内
https://leetcode.cn/problems/check-if-word-can-be-placed-in-crossword/

第 260 场周赛 T3。

给你一个 m x n 的矩阵 board ，它代表一个填字游戏 当前 的状态。填字游戏格子中包含小写英文字母（已填入的单词），表示 空 格的 ' ' 和表示 障碍 格子的 '#' 。
如果满足以下条件，那么我们可以 水平 （从左到右 或者 从右到左）或 竖直 （从上到下 或者 从下到上）填入一个单词：
- 该单词不占据任何 '#' 对应的格子。
- 每个字母对应的格子要么是 ' ' （空格）要么与 board 中已有字母 匹配 。
- 如果单词是 水平 放置的，那么该单词左边和右边 相邻 格子不能为 ' ' 或小写英文字母。
- 如果单词是 竖直 放置的，那么该单词上边和下边 相邻 格子不能为 ' ' 或小写英文字母。
给你一个字符串 word ，如果 word 可以被放入 board 中，请你返回 true ，否则请返回 false 。
提示：
m == board.length
n == board[i].length
1 <= m * n <= 2 * 10^5
board[i][j] 可能为 ' ' ，'#' 或者一个小写英文字母。
1 <= word.length <= max(m, n)
word 只包含小写英文字母。

遍历
时间复杂度 O(mn)
空间复杂度 O()
 */