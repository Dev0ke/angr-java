public class Solution2416 {
    public int[] sumPrefixScores(String[] words) {
        int len = words.length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = trie.startsWith(words[i]);
        }
        return res;
    }

    private static class Trie {
        private final Trie[] children;
        // 有多少个前缀
        private int val;

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
                node.val++;
            }
        }

        public int startsWith(String prefix) {
            int res = 0;
            Trie node = this;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return res;
                }
                node = node.children[idx];
                res += node.val;
            }
            return res;
        }
    }
}
/*
2416. 字符串的前缀分数和
https://leetcode.cn/problems/sum-of-prefix-scores-of-strings/

第 311 场周赛 T4。

给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。
定义字符串 word 的 分数 等于以 word 作为 前缀 的 words[i] 的数目。
- 例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 "abc" 的一个前缀。
返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。
注意：字符串视作它自身的一个前缀。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] 由小写英文字母组成

暴力时间复杂度 O(n^2*|s|) 会 TLE..
Trie 字典树。
时间复杂度 O(n*|s|)
相似题目: 208. 实现 Trie (前缀树)
https://leetcode.cn/problems/implement-trie-prefix-tree/
 */