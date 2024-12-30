import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private char[][] board;
    private int m, n;
    private Set<String> set;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(trie, i, j);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(Trie trie, int x, int y) {
        char ch = board[x][y];
        if (trie.children[ch - 'a'] == null) {
            return;
        }
        trie = trie.children[ch - 'a'];
        if (trie.word != null) {
            set.add(trie.word);
        }
        // ascii码序 排在 'z' 后的一个字符是 '{'
        board[x][y] = '{';
        for (int[] dir : DIRECTIONS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                dfs(trie, nx, ny);
            }
        }
        board[x][y] = ch;
    }

    private static class Trie {
        Trie[] children;
        String word;

        public Trie() {
            // 'a'~'z' + '{'
            children = new Trie[27];
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
    }
}
/*
212. 单词搜索 II
https://leetcode.cn/problems/word-search-ii/

给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
提示：
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同

前缀树 + DFS
 */