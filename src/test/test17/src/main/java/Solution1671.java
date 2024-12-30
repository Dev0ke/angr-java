public class Solution1671 {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;

        // LIS
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        // LIS
        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = len - 1; j > i; j--) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        // arr.length >= 3 题目保证 nums 删除一些元素后一定能得到山形数组。
        int maxLen = 3;
        for (int i = 0; i < len; i++) {
            if (left[i] > 1 && right[i] > 1) {
                maxLen = Math.max(maxLen, left[i] + right[i] - 1);
            }
        }
        return len - maxLen;
    }
}
/*
1671. 得到山形数组的最少删除次数
https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/

我们定义 arr 是 山形数组 当且仅当它满足：
- arr.length >= 3
- 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给你整数数组 nums  ，请你返回将 nums 变成 山形状数组 的  最少 删除次数。
提示：
3 <= nums.length <= 1000
1 <= nums[i] <= 10^9
题目保证 nums 删除一些元素后一定能得到山形数组。

两遍 LIS。
时间复杂度 O(n^2) 可用二分优化至 O(nlogn)
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */