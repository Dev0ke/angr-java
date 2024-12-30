import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionP1858 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.longestWord();
    }

    private static class Trie {
        private final Trie[] children;
        private String word;

        public Trie() {
            children = new Trie[26];
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

        public String longestWord() {
            Queue<Trie> queue = new LinkedList<>();
            this.word = "";
            queue.add(this);
            String res = "";
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Trie cur = queue.remove();
                    if (cur == null || cur.word == null) {
                        continue;
                    }
                    // 更新结果
                    if (cur.word.length() > res.length()) {
                        res = cur.word;
                    }
                    queue.addAll(Arrays.asList(cur.children));
                }
            }
            return res;
        }
    }
}
/*
$1858. 包含所有前缀的最长单词
https://leetcode.cn/problems/longest-word-with-all-prefixes/

给定一个字符串数组 words，找出 words 中所有的前缀都在 words 中的最长字符串。
- 例如，令 words = ["a", "app", "ap"]。字符串 "app" 含前缀 "ap" 和 "a" ，都在 words 中。
返回符合上述要求的字符串。如果存在多个（符合条件的）相同长度的字符串，返回字典序中最小的字符串，如果这样的字符串不存在，返回 ""。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 10^5
1 <= sum(words[i].length) <= 10^5

前缀树
同: 720. 词典中最长的单词
https://leetcode.cn/problems/longest-word-in-dictionary/
 */