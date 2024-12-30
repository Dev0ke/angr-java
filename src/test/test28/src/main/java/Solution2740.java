import java.util.Arrays;

public class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n - 1];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}
/*
2740. 找出分区值
https://leetcode.cn/problems/find-the-value-of-the-partition/

第 350 场周赛 T2。

给你一个 正 整数数组 nums 。
将 nums 分成两个数组：nums1 和 nums2 ，并满足下述条件：
- 数组 nums 中的每个元素都属于数组 nums1 或数组 nums2 。
- 两个数组都 非空 。
- 分区值 最小 。
分区值的计算方法是 |max(nums1) - min(nums2)| 。
其中，max(nums1) 表示数组 nums1 中的最大元素，min(nums2) 表示数组 nums2 中的最小元素。
返回表示分区值的整数。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

排序后遍历
时间复杂度 O(nlogn)
 */