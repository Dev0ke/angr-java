public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int min_suf = nums[n - 1]; // 后缀最小值
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min_suf) return false;
            min_suf = Math.min(min_suf, nums[i+1]);
        }
        return true;
    }
}
/*
775. 全局倒置与局部倒置
https://leetcode.cn/problems/global-and-local-inversions/description/

给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
- 0 <= i < j < n
- nums[i] > nums[j]
局部倒置 的数目等于满足下述条件的下标 i 的数目：
- 0 <= i < n - 1
- nums[i] > nums[i + 1]
当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
提示：
n == nums.length
1 <= n <= 10^5
0 <= nums[i] < n
nums 中的所有整数 互不相同
nums 是范围 [0, n - 1] 内所有数字组成的一个排列

维护后缀最小值。
一个局部倒置一定是一个全局倒置，因此要判断数组中局部倒置的数量是否与全局倒置的数量相等，只需要检查有没有非局部倒置就可以了。
这里的非局部倒置指的是 nums[i]>nums[j]，其中 i<j−1。
时间复杂度 O(n)。
 */