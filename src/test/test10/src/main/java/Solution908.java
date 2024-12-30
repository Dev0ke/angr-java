public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max - min > k * 2) {
            return max - min - k * 2;
        }
        return 0;
    }
}
/*
908. 最小差值 I
https://leetcode.cn/problems/smallest-range-i/

第 103 场周赛 T1。

给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
nums 的 分数 是 nums 中最大和最小元素的差值。
在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
提示：
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^4
0 <= k <= 10^4

加上一个任意数字 x （-k <= x <= k）
因此相差 2k 以内的可以看成被 “抹平”
 */