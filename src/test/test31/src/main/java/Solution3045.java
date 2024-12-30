import java.util.HashMap;
import java.util.Map;

public class Solution3045 {
    public long countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode();
        long ans = 0;
        for (String word : words) {
            int n = word.length();
            int[] z = z_function(n, word.toCharArray());
            z[0] = n;

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.child[idx] == null) {
                    break;
                }
                node = node.child[idx];
                if (i + 1 == z[n - 1 - i]) {
                    ans += node.cnt;
                }
            }

            // insert
            node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
            }
            node.cnt++;
        }
        return ans;
    }

    static class TrieNode {
        TrieNode[] child;
        int cnt;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.cnt = 0;
        }
    }

    private int[] z_function(int n, char[] s) {
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    static class V2 {
        public long countPrefixSuffixPairs(String[] words) {
            TrieNode root = new TrieNode();
            long ans = 0;
            for (String w : words) {
                char[] s = w.toCharArray();
                int n = s.length;
                TrieNode node = root;
                for (int i = 0; i < n; i++) {
                    String p = "" + s[i] + s[n - 1 - i];
                    node = node.child.computeIfAbsent(p, e -> new TrieNode());
                    ans += node.cnt;
                }
                node.cnt++;
            }
            return ans;
        }

        static class TrieNode {
            Map<String, TrieNode> child = new HashMap<>();
            int cnt;
        }
    }
}
/*
3045. 统计前后缀下标对 II
https://leetcode.cn/problems/count-prefix-and-suffix-pairs-ii/description/

第 385 场周赛 T4。

给你一个下标从 0 开始的字符串数组 words 。
定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ：
- 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 true，否则返回 false。
例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 "ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。
以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的 数量 。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 10^5
words[i] 仅由小写英文字母组成。
所有 words[i] 的长度之和不超过 5 * 10^5 。

Z 函数 + 字典树。
时间复杂度 O(L)。
相似题目: 745. 前缀和后缀搜索
https://leetcode.cn/problems/prefix-and-suffix-search/description/
 */