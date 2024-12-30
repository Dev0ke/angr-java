public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 插入位置之后的数都 >= target，FFFTTT
    private boolean checkMid(int[] nums, int target, int mid) {
        return nums[mid] >= target;
    }
}
/*
35. 搜索插入位置
https://leetcode.cn/problems/search-insert-position/

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。
提示:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums 为无重复元素的升序排列数组
-10^4 <= target <= 10^4

二分
 */
