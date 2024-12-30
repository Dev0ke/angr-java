import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution720 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.longestWord();
    }

    /**
     * 字典树
     */
    private static class Trie {
        /**
         * 字典树节点
         */
        private static class TrieNode {
            TrieNode[] children;
            String word;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.word = "";
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.word = word;
        }

        public String longestWord() {
            Queue<TrieNode> queue = new LinkedList<>();
            queue.add(root);
            String res = "";
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode cur = queue.remove();
                    if (cur == null || cur.word == null) {
                        continue;
                    }
                    // 更新结果
                    if (cur.word.length() > res.length()) {
                        res = cur.word;
                    }
                    if (cur.children != null) {
                        queue.addAll(Arrays.asList(cur.children));
                    }
                }
            }
            return res;
        }
    }
}
/*
720. 词典中最长的单词
https://leetcode.cn/problems/longest-word-in-dictionary/

给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
若其中有多个可行的答案，则返回答案中字典序最小的单词。
若无答案，则返回空字符串。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 30
所有输入的字符串 words[i] 都只包含小写字母。

字典树 + BFS。
BFS 即 N 叉树层序遍历。
同: 1858. 包含所有前缀的最长单词
https://leetcode.cn/problems/longest-word-with-all-prefixes
 */