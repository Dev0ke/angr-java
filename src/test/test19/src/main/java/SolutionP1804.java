public class SolutionP1804 {
    static class Trie {
        private final Trie[] children;
        // 以 word 为字符串的个数
        private int cntWord;
        // 以 prefix 为前缀的个数
        private int cntPrefix;

        public Trie() {
            children = new Trie[26];
            cntWord = 0;
            cntPrefix = 0;
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node.children[idx].cntPrefix++;
                node = node.children[idx];
            }
            node.cntWord++;
        }

        public int countWordsEqualTo(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return 0;
                }
                node = node.children[idx];
            }
            return node.cntWord;
        }

        public int countWordsStartingWith(String prefix) {
            Trie node = this;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return 0;
                }
                node = node.children[idx];
            }
            return node.cntPrefix;
        }

        public void erase(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return;
                }
                node.children[idx].cntPrefix--;
                node = node.children[idx];
            }
            node.cntWord--;
        }
    }
}
/*
$1804. 实现 Trie （前缀树） II
https://leetcode.cn/problems/implement-trie-ii-prefix-tree/

前缀树（trie ，发音为 "try"）是一个树状的数据结构，用于高效地存储和检索一系列字符串的前缀。前缀树有许多应用，如自动补全和拼写检查。
实现前缀树 Trie 类：
- Trie() 初始化前缀树对象。
- void insert(String word) 将字符串 word 插入前缀树中。
- int countWordsEqualTo(String word) 返回前缀树中字符串 word 的实例个数。
- int countWordsStartingWith(String prefix) 返回前缀树中以 prefix 为前缀的字符串个数。
- void erase(String word) 从前缀树中移除字符串 word 。
提示：
1 <= word.length, prefix.length <= 2000
word 和 prefix 只包含小写英文字母。
insert、 countWordsEqualTo、 countWordsStartingWith 和 erase 总共调用最多 3 * 10^4 次。
保证每次调用 erase 时，字符串 word 总是存在于前缀树中。

相似题目: 208. 实现 Trie (前缀树)
https://leetcode.cn/problems/implement-trie-prefix-tree/
 */