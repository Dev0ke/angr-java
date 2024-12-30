public class Solution1979 {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return getGCD(min, max);
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
1979. 找出数组的最大公约数
https://leetcode.cn/problems/find-greatest-common-divisor-of-array/

第 255 场周赛 T1。

给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
两个数的 最大公约数 是能够被两个数整除的最大正整数。
提示：
2 <= nums.length <= 1000
1 <= nums[i] <= 1000

分别找出数组中最大最小的数，求 GCD 即可。
 */