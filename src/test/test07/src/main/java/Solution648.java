import java.util.List;

public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dict : dictionary) {
            trie.insert(dict);
        }

        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            String prefix = trie.findPrefix(sentences[i]);
            if (prefix.length() != 0) {
                sentences[i] = prefix;
            }
        }
        return String.join(" ", sentences);
    }

    static class Trie {
        private final Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
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
            node.isWord = true;
        }

        public String findPrefix(String prefix) {
            Trie node = this;
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.isWord || node.children[idx] == null) {
                    break;
                }
                stringBuilder.append(ch);
                node = node.children[idx];
            }
            return node.isWord ? stringBuilder.toString() : "";
        }
    }
}
/*
648. 单词替换
https://leetcode.cn/problems/replace-words/

在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。
如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
提示：
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] 仅由小写字母组成。
1 <= sentence.length <= 10^6
sentence 仅由小写字母和空格组成。
sentence 中单词的总量在范围 [1, 1000] 内。
sentence 中每个单词的长度在范围 [1, 1000] 内。
sentence 中单词之间由一个空格隔开。
sentence 没有前导或尾随空格。

前缀树。
 */