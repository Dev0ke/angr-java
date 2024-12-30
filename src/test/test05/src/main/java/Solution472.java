import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution472 {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (word.isEmpty()) continue;
            boolean[] vis = new boolean[word.length()];
            if (dfs(0, word, vis)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    private boolean dfs(int st, String s, boolean[] vis) {
        if (st == s.length()) return true;
        if (vis[st]) return false;
        vis[st] = true;
        TrieNode node = root;
        for (int i = st; i < s.length(); i++) {
            int b = s.charAt(i) - 'a';
            if (node.child[b] == null) {
                return false;
            }
            node = node.child[b];
            if (node.isWord) {
                if (dfs(i + 1, s, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int b = c - 'a';
            if (node.child[b] == null) {
                node.child[b] = new TrieNode();
            }
            node = node.child[b];
        }
        node.isWord = true;
    }

    static class TrieNode {
        TrieNode[] child;
        boolean isWord;

        public TrieNode() {
            this.child = new TrieNode[26];
        }
    }
}
/*
472. 连接词
https://leetcode.cn/problems/concatenated-words/description/

给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
连接词 定义为：一个完全由给定数组中的至少两个较短单词（不一定是不同的两个单词）组成的字符串。
提示：
1 <= words.length <= 10^4
1 <= words[i].length <= 30
words[i] 仅由小写英文字母组成。
words 中的所有字符串都是 唯一 的。
1 <= sum(words[i].length) <= 10^5

字典树。
时间复杂度 O(nlogn + L)。其中 L 表示 words 的字符串总长度。
 */