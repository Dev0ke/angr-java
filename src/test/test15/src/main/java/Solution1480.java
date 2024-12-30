public class Solution1480 {
    public int[] runningSum(int[] nums) {
        int len = nums.length;

        int sum = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
/*
1480. 一维数组的动态和
https://leetcode.cn/problems/running-sum-of-1d-array/

给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
请返回 nums 的动态和。
提示：
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6

模拟。
 */