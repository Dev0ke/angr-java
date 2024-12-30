public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len / 2;
        while (left < right) {
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            int mid = left + (right - left) / 2;
            if (!checkMid(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left * 2];
    }

    // 每对数都成对出现，在单一元素出现后，存在 TTTFFF
    private boolean checkMid(int[] nums, int mid) {
        return nums[mid * 2] == nums[mid * 2 + 1];
    }
}
/*
540. 有序数组中的单一元素
https://leetcode.cn/problems/single-element-in-a-sorted-array/

给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
请你找出并返回只出现一次的那个数。
你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
提示:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

数组中的数字每两个分成一组，左侧的若干组的两个数组是相同的，右侧若干组的数组是不同的。
只出现一次的数字正好是第一个两个数字不相等的分组的第一个数字。
二分。
 */