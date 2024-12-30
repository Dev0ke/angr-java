import java.util.Arrays;

public class Solution2535 {
    public int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int digitSum = 0;
        for (int x : nums) {
            while (x > 0) {
                digitSum += x % 10;
                x /= 10;
            }
        }
        return Math.abs(sum - digitSum);
    }
}
/*
2535. 数组元素和与数字和的绝对差
https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/

第 328 场周赛 T1。

给你一个正整数数组 nums 。
- 元素和 是 nums 中的所有元素相加求和。
- 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
返回 元素和 与 数字和 的绝对差。
注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
提示：
1 <= nums.length <= 2000
1 <= nums[i] <= 2000

模拟
时间复杂度 O(nlogU) U = max(nums)
 */