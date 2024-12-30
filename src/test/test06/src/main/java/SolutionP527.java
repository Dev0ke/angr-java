import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP527 {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<IndexedWord>> groups = new HashMap<>();
        String[] ans = new String[words.size()];

        int idx = 0;
        for (String word : words) {
            String abbr = abbrev(word, 0);
            groups.computeIfAbsent(abbr, e -> new ArrayList<>()).add(new IndexedWord(word, idx));
            idx++;
        }

        for (List<IndexedWord> group : groups.values()) {
            TrieNode trie = new TrieNode();
            for (IndexedWord iw : group) {
                TrieNode cur = trie;
                for (char ch : iw.word.substring(1).toCharArray()) {
                    if (cur.child[ch - 'a'] == null) {
                        cur.child[ch - 'a'] = new TrieNode();
                    }
                    cur.cnt++;
                    cur = cur.child[ch - 'a'];
                }
            }

            for (IndexedWord iw : group) {
                TrieNode cur = trie;
                int i = 1;
                for (char ch : iw.word.substring(1).toCharArray()) {
                    if (cur.cnt == 1) break;
                    cur = cur.child[ch - 'a'];
                    i++;
                }
                ans[iw.idx] = abbrev(iw.word, i - 1);
            }
        }

        return Arrays.asList(ans);
    }

    private String abbrev(String word, int i) {
        int n = word.length();
        if (n - i <= 3) return word;
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }

    static class TrieNode {
        TrieNode[] child;
        int cnt;

        TrieNode() {
            child = new TrieNode[26];
            cnt = 0;
        }
    }

    static class IndexedWord {
        String word;
        int idx;

        IndexedWord(String w, int i) {
            word = w;
            idx = i;
        }
    }
}
/*
$527. 单词缩写
https://leetcode.cn/problems/word-abbreviation/description/

给你一个字符串数组 words ，该数组由 互不相同 的若干字符串组成，请你找出并返回每个单词的 最小缩写 。
生成缩写的规则如下：
1.初始缩写由起始字母+省略字母的数量+结尾字母组成。
2.若存在冲突，亦即多于一个单词有同样的缩写，则使用更长的前缀代替首字母，直到从单词到缩写的映射唯一。换而言之，最终的缩写必须只能映射到一个单词。
3.若缩写并不比原单词更短，则保留原样。
提示：
1 <= words.length <= 400
2 <= words[i].length <= 400
words[i] 由小写英文字母组成
words 中的所有字符串 互不相同

分组 + 字典树。
时间复杂度 O(C)。其中 C 是给定数组中所有单词的字符数量。
 */