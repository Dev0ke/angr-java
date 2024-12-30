public class Solution3277 {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int[][] mx = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = nums[i];
            mx[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                f[i][j] = f[i][j - 1] ^ f[i + 1][j];
                mx[i][j] = Math.max(f[i][j], Math.max(mx[i + 1][j], mx[i][j - 1]));
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int L = queries[i][0], R = queries[i][1];
            ans[i] = mx[L][R];
        }
        return ans;
    }
}
/*
3277. 查询子数组最大异或值
https://leetcode.cn/problems/maximum-xor-score-subarray-queries/description/

第 413 场周赛 T4。

给你一个由 n 个整数组成的数组 nums，以及一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri]。
对于每一个查询，你需要找出 nums[li..ri] 中任意 子数组 的 最大异或值。
数组的异或值 需要对数组 a 反复执行以下操作，直到只剩一个元素，剩下的那个元素就是 异或值：
- 对于除最后一个下标以外的所有下标 i，同时将 a[i] 替换为 a[i] XOR a[i + 1] 。
- 移除数组的最后一个元素。
返回一个大小为 q 的数组 answer，其中 answer[i] 表示查询 i 的答案。
提示：
1 <= n == nums.length <= 2000
0 <= nums[i] <= 2^31 - 1
1 <= q == queries.length <= 10^5
queries[i].length == 2
queries[i] = [li, ri]
0 <= li <= ri <= n - 1

区间 DP 套区间 DP。
https://leetcode.cn/problems/maximum-xor-score-subarray-queries/solutions/2899932/qu-jian-dp-tao-qu-jian-dppythonjavacgo-b-w4be/
赛时以为跟 1310 一样，先做前缀和，再套 0-1 Trie，但其实不是。。
时间复杂度 O(n^2 + q)。
rating 2711 (clist.by)
相似题目: 1310. 子数组异或查询
https://leetcode.cn/problems/xor-queries-of-a-subarray/
 */