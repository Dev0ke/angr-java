public class Solution3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // insert
        TrieNode root = new TrieNode();
        for (int x : arr1) {
            TrieNode node = root;
            for (char c : String.valueOf(x).toCharArray()) {
                int idx = c - '0';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
            }
        }

        // search
        int ans = 0;
        for (int x : arr2) {
            TrieNode node = root;
            int cnt = 0;
            for (char c : String.valueOf(x).toCharArray()) {
                int idx = c - '0';
                if (node.child[idx] == null) {
                    break;
                }
                node = node.child[idx];
                cnt++;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    static class TrieNode {
        TrieNode[] child;

        public TrieNode() {
            this.child = new TrieNode[10];
        }
    }
}
/*
3043. 最长公共前缀的长度
https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/

第 385 场周赛 T2。

给你两个 正整数 数组 arr1 和 arr2 。
正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。
设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 ，而 1223 和 43456 没有 公共前缀。
你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。
返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。
提示：
1 <= arr1.length, arr2.length <= 5 * 10^4
1 <= arr1[i], arr2[i] <= 10^8

字典树。
时间复杂度 O(nL + mL)
 */