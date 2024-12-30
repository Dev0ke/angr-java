public class Solution3065 {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int v : nums) {
            if (v < k) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3065. 超过阈值的最少操作数 I
https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/description/

第 125 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
一次操作中，你可以删除 nums 中的最小元素。
你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 10^9
1 <= k <= 10^9
输入保证至少有一个满足 nums[i] >= k 的下标 i 存在。

遍历。
时间复杂度 O(n)。
 */