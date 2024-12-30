public class SolutionP1060 {
    public int missingElement(int[] nums, int k) {
        int len = nums.length;

        if (missing(nums, len - 1) < k) {
            return nums[len - 1] + k - missing(nums, len - 1);
        }

        // 二分查找 missing[idx-1] < k <= missing[idx]
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            // FFFTTT
            if (missing(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left - 1] + k - missing(nums, left - 1);
    }

    // missing[idx] 表示到 idx 为止缺失数字的个数
    // [4, 7, 9, 10] 0,2,3,3
    private int missing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}
/*
$1060. 有序数组中的缺失元素
https://leetcode.cn/problems/missing-element-in-sorted-array/

现有一个按 升序 排列的整数数组 nums ，其中每个数字都 互不相同 。
给你一个整数 k ，请你找出并返回从数组最左边开始的第 k 个缺失数字。
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^7
nums 按 升序 排列，其中所有元素 互不相同 。
1 <= k <= 10^8
进阶：你可以设计一个对数时间复杂度（即，O(log(n))）的解决方案吗？

二分
 */