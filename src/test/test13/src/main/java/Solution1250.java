public class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        // 裴蜀定理
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = getGCD(gcd, nums[i]);
            if (gcd == 1) {
                break;
            }
        }
        return gcd == 1;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
1250. 检查「好数组」
https://leetcode.cn/problems/check-if-it-is-a-good-array/

给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

裴蜀定理
相似题目: 365. 水壶问题
https://leetcode.cn/problems/water-and-jug-problem/
 */