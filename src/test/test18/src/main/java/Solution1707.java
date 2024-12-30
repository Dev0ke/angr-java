import java.util.Arrays;
import java.util.Comparator;

public class Solution1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        Arrays.sort(nums);

        Integer[] ids = new Integer[q];
        for (int i = 0; i < q; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> queries[o][1]));

        Trie trie = new Trie(n, 32);

        int[] ans = new int[q];
        int loc = 0; // 记录 nums 中哪些位置之前的数已经放入 Trie
        for (int i = 0; i < q; i++) {
            int id = ids[i];
            int x = queries[id][0], limit = queries[id][1];
            // 将小于等于 limit 的数存入 Trie
            while (loc < n && nums[loc] <= limit) {
                trie.insert(nums[loc]);
                loc++;
            }
            if (loc == 0) {
                ans[id] = -1;
            } else {
                ans[id] = trie.query(x);
            }
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
1707. 与数组中元素的最大异或值
https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/

给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
提示：
1 <= nums.length, queries.length <= 10^5
queries[i].length == 2
0 <= nums[j], xi, mi <= 10^9

离线询问 + 0-1 Trie
相似题目: 421. 数组中两个数的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
$2479. 两个不重叠子树的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/description/
 */