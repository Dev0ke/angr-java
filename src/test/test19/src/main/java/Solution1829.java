public class Solution1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xor_sum = 0;
        for (int v : nums) {
            xor_sum ^= v;
        }
        int full = (1 << maximumBit) - 1;

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[n - 1 - i] = xor_sum ^ full;
            xor_sum ^= nums[i];
        }
        return ans;
    }
}
/*
1829. 每个查询的最大异或值
https://leetcode.cn/problems/maximum-xor-for-each-query/description/

给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。你需要执行以下查询 n 次：
1.找到一个非负整数 k < 2^maximumBit ，使得 nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。
2.从当前数组 nums 删除 最后 一个元素。
请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果。
提示：
nums.length == n
1 <= n <= 10^5
1 <= maximumBit <= 20
0 <= nums[i] < 2^maximumBit
nums 中的数字已经按 升序 排好序。

异或性质。
时间复杂度 O(n)。
 */