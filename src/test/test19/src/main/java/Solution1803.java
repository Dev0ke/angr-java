public class Solution1803 {
    // 84ms
    static class V1 {
        public int countPairs(int[] nums, int low, int high) {
            return f(nums, high) - f(nums, low - 1);
        }

        // f(x) 表示有多少对数字的异或运算结果小于等于 x
        private int f(int[] nums, int x) {
            int n = nums.length;
            int res = 0;
            Trie_Ref trie = new Trie_Ref();
            // Trie_Arr trie = new Trie_Arr(n, 15);
            for (int i = 1; i < n; i++) {
                trie.insert(nums[i - 1]);
                res += trie.query(nums[i], x);
            }
            return res;
        }

        static class Trie_Ref {
            int HIGH_BIT = 14;
            Trie root = new Trie();

            void insert(int x) {
                Trie cur = root;
                for (int k = HIGH_BIT; k >= 0; k--) {
                    int bit = x >> k & 1;
                    if (cur.child[bit] == null) {
                        cur.child[bit] = new Trie();
                    }
                    cur = cur.child[bit];
                    cur.sum++;
                }
            }

            int query(int x, int U) {
                Trie cur = root;
                int sum = 0;
                for (int k = HIGH_BIT; k >= 0; k--) {
                    int bit = x >> k & 1;
                    if ((U >> k & 1) == 1) {
                        if (cur.child[bit] != null) {
                            sum += cur.child[bit].sum;
                        }
                        if (cur.child[bit ^ 1] == null) {
                            return sum;
                        }
                        cur = cur.child[bit ^ 1];
                    } else {
                        if (cur.child[bit] == null) {
                            return sum;
                        }
                        cur = cur.child[bit];
                    }
                }
                sum += cur.sum;
                return sum;
            }

            static class Trie {
                Trie[] child = new Trie[2];
                int sum = 0;
            }
        }
    }

    // 66ms
    static class V2 {
        public int countPairs(int[] nums, int low, int high) {
            return f(nums, high) - f(nums, low - 1);
        }

        // f(x) 表示有多少对数字的异或运算结果小于等于 x
        private int f(int[] nums, int x) {
            int n = nums.length;
            int res = 0;
            Trie_Arr trie = new Trie_Arr(n, 15);
            for (int i = 1; i < n; i++) {
                trie.insert(nums[i - 1]);
                res += trie.query(nums[i], x);
            }
            return res;
        }

        // 0-1 Trie
        // 2^31
        private static class Trie_Arr {
            int[][] dict;
            int[] cnt;
            int nextIdx, m;

            // n:长度 m:2^m
            public Trie_Arr(int n, int m) {
                this.dict = new int[2][n * m + 2];
                this.cnt = new int[n * m + 2];
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
                    cnt[idx]++;
                }
            }

            public int query(int x, int U) {
                int sum = 0;
                int idx = 0;
                for (int k = m - 1; k >= 0; k--) {
                    int pos = x >> k & 1;
                    if ((U >> k & 1) == 1) {
                        if (dict[pos][idx] != 0) {
                            sum += cnt[dict[pos][idx]];
                        }
                        if (dict[pos ^ 1][idx] == 0) {
                            return sum;
                        }
                        idx = dict[pos ^ 1][idx];
                    } else {
                        if (dict[pos][idx] == 0) {
                            return sum;
                        }
                        idx = dict[pos][idx];
                    }
                }
                sum += cnt[idx];
                return sum;
            }
        }
    }
}
/*
1803. 统计异或值在范围内的数对有多少
https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/

给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。
漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[j]) <= high 。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 2 * 10^4
1 <= low <= high <= 2 * 10^4

0-1 Trie 的两种写法（对象引用 or 数组下标）
时间复杂度 O(nlogU)。
相似题目: 1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
E. Beautiful Subarrays
https://codeforces.com/contest/665/problem/E
E. Choosing The Commander
https://codeforces.com/contest/817/problem/E
$2479. 两个不重叠子树的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/description/
 */