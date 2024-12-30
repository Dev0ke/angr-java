import java.util.Arrays;

public class Solution2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int divideGCD = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            divideGCD = getGCD(divideGCD, numsDivide[i]);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= divideGCD; i++) {
            if (divideGCD % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2344. 使数组可以被整除的最少删除次数
https://leetcode.cn/problems/minimum-deletions-to-make-array-divisible/

第 302 场周赛 T4。

给你两个正整数数组 nums 和 numsDivide 。你可以从 nums 中删除任意数目的元素。
请你返回使 nums 中 最小 元素可以整除 numsDivide 中所有元素的 最少 删除次数。如果无法得到这样的元素，返回 -1 。
如果 y % x == 0 ，那么我们说整数 x 整除 y 。
提示：
1 <= nums.length, numsDivide.length <= 10^5
1 <= nums[i], numsDivide[i] <= 10^9

只有 numsDivide 的最大公约数的因数才能整除 numsDivide 中的所有数。
时间复杂度 O(nlogA + nlogn) 其中 A 是 numsDivide 中的最大元素。
 */