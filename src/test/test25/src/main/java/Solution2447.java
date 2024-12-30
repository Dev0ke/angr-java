public class Solution2447 {
    public int subarrayGCD(int[] nums, int k) {
        int len = nums.length;

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int gcd = nums[i];
            for (int j = i; j < len; j++) {
                gcd = getGCD(gcd, nums[j]);
                if (gcd == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2447. 最大公因数等于 K 的子数组数目
https://leetcode.cn/problems/number-of-subarrays-with-gcd-equal-to-k/

第 316 场周赛 T2。

给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。
子数组 是数组中一个连续的非空序列。
数组的最大公因数 是能整除数组中所有元素的最大整数。
提示：
1 <= nums.length <= 1000
1 <= nums[i], k <= 10^9

暴力模拟
时间复杂度 O(n^2)
 */