import java.util.Arrays;
import java.util.Random;

public class Solution215 {
    /**
     * 数组排序后，返回对应下标
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(logn) 即递归使用栈空间的空间代价。
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 快排 partition 函数
     * 时间复杂度 O(n)
     * 空间复杂度 O(logn) 即递归使用栈空间的空间代价。
     */
    public int findKthLargest2(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int idx = partition(nums, start, end);
        while (idx != target) {
            if (idx > target) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
            idx = partition(nums, start, end);
        }
        return nums[idx];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
/*
215. 数组中的第K个最大元素
https://leetcode.cn/problems/kth-largest-element-in-an-array/

给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
提示：
1 <= k <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4

直接排序/基于快速排序的选择方法
 */