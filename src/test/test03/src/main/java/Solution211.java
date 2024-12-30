public class Solution211 {
    static class WordDictionary {
        private final WordDictionary[] children;
        private boolean isWord;

        public WordDictionary() {
            children = new WordDictionary[26];
            isWord = false;
        }

        public void addWord(String word) {
            WordDictionary node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new WordDictionary();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, this);
        }

        private boolean dfs(String word, int index, WordDictionary node) {
            if (index == word.length()) {
                return node.isWord;
            }
            // 每个 . 都可以表示任何一个字母。
            if (word.charAt(index) == '.') {
                for (int i = 0; i < 26; i++) {
                    WordDictionary child = node.children[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            } else {
                int idx = word.charAt(index) - 'a';
                WordDictionary child = node.children[idx];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
    }
}
/*
211. 添加与搜索单词 - 数据结构设计
https://leetcode.cn/problems/design-add-and-search-words-data-structure/

请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
- WordDictionary() 初始化词典对象
- void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
- bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
提示：
1 <= word.length <= 25
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最多调用 10^4 次 addWord 和 search

前缀树
 */