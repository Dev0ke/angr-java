import java.util.Arrays;

public class SolutionP644 {
    public double findMaxAverage(int[] nums, int k) {
        double left = Arrays.stream(nums).min().orElseThrow();
        double right = Arrays.stream(nums).max().orElseThrow();

        while (right - left > 1e-5) {
            double mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1e-5;
            }
        }
        return left;
    }

    // TTTFFF
    private boolean checkMid(int[] nums, int k, double mid) {
        double sum = 0;
        double prev = 0;
        double minSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            minSum = Math.min(minSum, prev);
            if (sum >= minSum) {
                return true;
            }
        }
        return false;
    }
}
/*
$644. 子数组最大平均数 II
https://leetcode.cn/problems/maximum-average-subarray-ii/

给你一个包含 n 个整数的数组 nums ，和一个整数 k 。
请你找出 长度大于等于 k 且含最大平均值的连续子数组。并输出这个最大平均值。任何计算误差小于 10^-5 的结果都将被视为正确答案。
提示：
n == nums.length
1 <= k <= n <= 10^4
-10^4 <= nums[i] <= 10^4

二分，注意浮点数
相似题目: $774. 最小化去加油站的最大距离
https://leetcode.cn/problems/minimize-max-distance-to-gas-station/
 */