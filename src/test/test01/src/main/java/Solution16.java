import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        // 最接近的三数之和
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {

            // 双指针
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int newSum = nums[i] + nums[left] + nums[right];
                // 更新 最接近的三数之和
                if (Math.abs(newSum - target) < Math.abs(closestSum - target)) {
                    closestSum = newSum;
                }
                if (newSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closestSum;
    }
}
/*
16. 最接近的三数之和
https://leetcode.cn/problems/3sum-closest/

给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。
提示：
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4

双指针
时间复杂度 O(n^2)
相似题目: 15. 三数之和
https://leetcode.cn/problems/3sum/
 */