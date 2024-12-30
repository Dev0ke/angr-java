public class Solution677 {
    static class MapSum {
        private static class TrieNode {
            TrieNode[] children;
            boolean isWord;
            int value;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            for (char ch : key.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.value = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    return 0;
                }
                node = node.children[ch - 'a'];
            }
            return getSum(node);
        }

        private int getSum(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int res = node.value;
            for (TrieNode child : node.children) {
                res += getSum(child);
            }
            return res;
        }
    }
}
/*
677. 键值映射
https://leetcode.cn/problems/map-sum-pairs/

设计一个 map ，满足以下几点:
- 字符串表示键，整数表示值
- 返回具有前缀等于给定字符串的键的值的总和
实现一个 MapSum 类：
- MapSum() 初始化 MapSum 对象
- void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
- int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
提示：
1 <= key.length, prefix.length <= 50
key 和 prefix 仅由小写英文字母组成
1 <= val <= 1000
最多调用 50 次 insert 和 sum

前缀树。
 */