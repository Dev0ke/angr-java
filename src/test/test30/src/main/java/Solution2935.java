import java.util.Arrays;

public class Solution2935 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Trie trie = new Trie(n, 32);
        int j = 0;
        int ans = 0;
        for (int x : nums) {
            // |x - y| <= min(x, y)
            // x - y <= x 和 y - x <= x
            // 0 <= y <= 2x
            while (j < n && nums[j] <= x + x) {
                trie.insert(nums[j], 1);
                j++;
            }
            ans = Math.max(ans, trie.query(x));
            trie.insert(x, -1);
        }
        return ans;
    }

    // 0-1 Trie
    // 2^31
    private static class Trie {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        // op:1 插入 op:-1 删除
        void insert(int x, int op) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx] += op;
            }
        }

        int query(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (cnt[dict[1 - pos][idx]] != 0) {
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
2935. 找出强数对的最大异或值 II
https://leetcode.cn/problems/maximum-strong-pair-xor-ii/description/

第 371 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ：
- |x - y| <= min(x, y)
你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。
返回数组 nums 所有可能的强数对中的 最大 异或值。
注意，你可以选择同一个整数两次来形成一个强数对。
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 2^20 - 1

带删除的 0-1 Trie
时间复杂度 O(nlogn + nlogU) 其中 logU 最大为 20
相似题目: 1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
 */