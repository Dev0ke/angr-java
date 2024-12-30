import java.util.Arrays;

public class Solution1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().orElseThrow();

        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, threshold, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 除数为 mid 时，能否使上述结果小于等于阈值 FFFTTT
    private boolean checkMid(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int num : nums) {
            if (num % mid == 0) {
                sum += num / mid;
            } else {
                sum += num / mid + 1;
            }
        }
        return sum <= threshold;
    }
}
/*
1283. 使结果不超过阈值的最小除数
https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold/

给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
题目保证一定有解。
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^6
nums.length <= threshold <= 10^6

二分
 */