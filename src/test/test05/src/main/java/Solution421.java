public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = (xor << 1);
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    private static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR2(int[] nums) {
        int n = nums.length;
        Trie trie = new Trie(n, 32);
        for (int x : nums) {
            trie.insert(x);
        }

        int ans = 0;
        for (int x : nums) {
            ans = Math.max(ans, trie.query(x));
        }
        return ans;
    }

    // 0-1 Trie
    // 2^31
    private static class Trie {
        int[][] dict;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        public void insert(int x) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
            }
        }

        public int query(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[1 - pos][idx] != 0) {
                    res |= 1 << k;
                    idx = dict[1 - pos][idx];
                } else {
                    idx = dict[pos][idx];
                }
            }
            return res;
        }
    }
}
/*
421. 数组中两个数的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/

给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
提示：
1 <= nums.length <= 2 * 10^5
0 <= nums[i] <= 2^31 - 1

一般解法 时间复杂度为 O(n^2)
0-1 Trie
时间复杂度 O(n)
相似题目: 1707. 与数组中元素的最大异或值
https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/
1803. 统计异或值在范围内的数对有多少
https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/
1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
$2479. 两个不重叠子树的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/description/
 */