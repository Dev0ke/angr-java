import java.util.Arrays;

public class Solution3010 {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums, 1, n);
        return nums[0] + nums[1] + nums[2];
    }
}
/*
3010. 将数组分成最小总代价的子数组 I
https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/

第 122 场双周赛 T1。

给你一个长度为 n 的整数数组 nums 。
一个数组的 代价 是它的 第一个 元素。比方说，[1,2,3] 的代价是 1 ，[3,4,1] 的代价是 3 。
你需要将 nums 分成 3 个 连续且没有交集 的子数组。
请你返回这些子数组的 最小 代价 总和 。
提示：
3 <= n <= 50
1 <= nums[i] <= 50

贪心。nums[1:] 部分取最小的两个数，加上 nums[0]。
时间复杂度 O(nlogn)。
 */