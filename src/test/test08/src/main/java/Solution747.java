public class Solution747 {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIdx = i;
            } else {
                if (nums[i] > secondMax) {
                    secondMax = nums[i];
                }
            }
        }
        if (max >= secondMax * 2) {
            return maxIdx;
        }
        return -1;
    }
}
/*
747. 至少是其他数字两倍的最大数
https://leetcode.cn/problems/largest-number-at-least-twice-of-others/

给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
提示：
1 <= nums.length <= 50
0 <= nums[i] <= 100
nums 中的最大元素是唯一的

一次遍历
时间复杂度 O(n)
 */