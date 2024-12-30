public class Solution1413 {
    public int minStartValue(int[] nums) {
        int max = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, 1 - sum);
        }
        return max;
    }
}
/*
1413. 逐步求和得到正数的最小值
https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/

给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
提示：
1 <= nums.length <= 100
-100 <= nums[i] <= 100

贪心。
 */