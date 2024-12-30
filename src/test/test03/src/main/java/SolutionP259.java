import java.util.Arrays;

public class SolutionP259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // target = nums[i] + twoSum
            sum += twoSum(nums, target - nums[i], i + 1);
        }
        return sum;
    }

    private int twoSum(int[] nums, int target, int i) {
        int sum = 0;
        int left = i;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}
/*
$259. 较小的三数之和
https://leetcode.cn/problems/3sum-smaller/

给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
提示:
n == nums.length
0 <= n <= 3500
-100 <= nums[i] <= 100
-100 <= target <= 100

双指针两数之和
时间复杂度 O(n^2)
 */