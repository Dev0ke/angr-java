public class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        // 前缀异或
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] ^ arr[i];
        }

        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = preSum[r + 1] ^ preSum[l];
        }
        return res;
    }
}
/*
1310. 子数组异或查询
https://leetcode.cn/problems/xor-queries-of-a-subarray/

有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
并返回一个包含给定查询 queries 所有结果的数组。
提示：
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length

前缀“异或和”
时间复杂度 O(n)
 */