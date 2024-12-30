public class Solution3093 {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int q = wordsQuery.length;

        // insert
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            char[] s = wordsContainer[i].toCharArray();
            TrieNode node = root;
            if (node.minL > s.length) {
                node.minL = s.length;
                node.i = i;
            }
            for (int j = s.length - 1; j >= 0; j--) {
                int b = s[j] - 'a';
                if (node.child[b] == null) {
                    node.child[b] = new TrieNode();
                }
                node = node.child[b];
                if (node.minL > s.length) {
                    node.minL = s.length;
                    node.i = i;
                }
            }
        }

        // query
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            char[] s = wordsQuery[i].toCharArray();
            TrieNode node = root;
            for (int j = s.length - 1; j >= 0; j--) {
                int b = s[j] - 'a';
                if (node.child[b] != null) {
                    node = node.child[b];
                } else {
                    break;
                }
            }
            ans[i] = node.i;
        }
        return ans;
    }

    static class TrieNode {
        TrieNode[] child;
        int minL, i;

        public TrieNode() {
            this.child = new TrieNode[26];
            minL = Integer.MAX_VALUE;
        }
    }
}
/*
3093. 最长公共后缀查询
https://leetcode.cn/problems/longest-common-suffix-queries/description/

第 390 场周赛 T4。

给你两个字符串数组 wordsContainer 和 wordsQuery 。
对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果 wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 wordsContainer 中出现 更早 的一个。
请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。
提示：
1 <= wordsContainer.length, wordsQuery.length <= 10^4
1 <= wordsContainer[i].length <= 5 * 10^3
1 <= wordsQuery[i].length <= 5 * 10^3
wordsContainer[i] 只包含小写英文字母。
wordsQuery[i] 只包含小写英文字母。
wordsContainer[i].length 的和至多为 5 * 10^5 。
wordsQuery[i].length 的和至多为 5 * 10^5 。

字典树。
时间复杂度 O(L1*26 + L2)。其中 L1 为 wordsContainer 所有字符串长度之和。L2 为 wordsQuery 所有字符串长度之和。
相似题目: 3043. 最长公共前缀的长度
https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/
 */