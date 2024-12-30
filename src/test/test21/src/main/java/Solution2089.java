import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        if (Arrays.binarySearch(nums, target) < 0) {
            return new ArrayList<>();
        }
        int leftIdx = binarySearchLeftBound(nums, target);
        int rightIdx = binarySearchRightBound(nums, target);
        List<Integer> resList = new ArrayList<>();
        for (int i = leftIdx; i <= rightIdx; i++) {
            resList.add(i);
        }
        return resList;
    }

    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
2089. 找出数组排序后的目标下标
https://leetcode.cn/problems/find-target-indices-after-sorting-array/

第 269 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
目标下标 是一个满足 nums[i] == target 的下标 i 。
将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
提示：
1 <= nums.length <= 100
1 <= nums[i], target <= 100

二分查找。因需要排序，时间复杂度 O(nlogn)
数据量较少，线性查找也 ok。

相似题目: 34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */