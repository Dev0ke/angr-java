import java.util.HashMap;
import java.util.Map;

public class Solution745 {
    static class WordFilter {
        TrieNode root = new TrieNode();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                TrieNode cur = root;
                int n = word.length();
                for (int j = 0; j < n; j++) {
                    TrieNode tmp = cur;
                    for (int k = j; k < n; k++) {
                        String key = word.charAt(k) + "#";
                        tmp.child.computeIfAbsent(key, e -> new TrieNode());
                        tmp = tmp.child.get(key);
                        tmp.weight = i;
                    }
                    tmp = cur;
                    for (int k = j; k < n; k++) {
                        String key = "#" + word.charAt(n - 1 - k);
                        tmp.child.computeIfAbsent(key, e -> new TrieNode());
                        tmp = tmp.child.get(key);
                        tmp.weight = i;
                    }
                    String key = "" + word.charAt(j) + word.charAt(n - 1 - j);
                    cur.child.computeIfAbsent(key, e -> new TrieNode());
                    cur = cur.child.get(key);
                    cur.weight = i;
                }
            }
        }

        public int f(String pref, String suff) {
            TrieNode node = root;
            int n = pref.length(), m = suff.length();
            for (int i = 0; i < Math.max(n, m); i++) {
                char c1 = i < n ? pref.charAt(i) : '#';
                char c2 = i < m ? suff.charAt(m - 1 - i) : '#';
                String key = "" + c1 + c2;
                if (!node.child.containsKey(key)) {
                    return -1;
                }
                node = node.child.get(key);
            }
            return node.weight;
        }

        static class TrieNode {
            Map<String, TrieNode> child = new HashMap<>();
            int weight;
        }
    }
}
/*
745. 前缀和后缀搜索
https://leetcode.cn/problems/prefix-and-suffix-search/description/

设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
实现 WordFilter 类：
- WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
- f(string pref, string suff) 返回词典中具有前缀 pref 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
提示：
1 <= words.length <= 10^4
1 <= words[i].length <= 7
1 <= pref.length, suff.length <= 7
words[i]、pref 和 suff 仅由小写英文字母组成
最多对函数 f 执行 10^4 次调用

字典树。
相似题目: 3045. 统计前后缀下标对 II
https://leetcode.cn/problems/count-prefix-and-suffix-pairs-ii/description/
 */