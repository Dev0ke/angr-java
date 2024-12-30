import java.util.Arrays;

public class SolutionP1918 {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int mn = Arrays.stream(nums).min().orElseThrow();
        int sum = Arrays.stream(nums).sum();

        int left = mn;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] nums, int k, int threshold) {
        int tot = 0;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > threshold) {
                sum -= nums[l];
                l++;
            }
            tot += r - l + 1;
            r++;
        }
        return tot >= k;
    }
}
/*
$1918. 第 K 小的子数组和
https://leetcode.cn/problems/kth-smallest-subarray-sum/description/

给你一个 长度为 n 的整型数组 nums 和一个数值 k ，返回 第 k 小的子数组和。
子数组 是指数组中一个 非空 且不间断的子序列。  子数组和 则指子数组中所有元素的和。
提示:
n == nums.length
1 <= n <= 2 * 10^4
1 <= nums[i] <= 5 * 10^4
1 <= k <= n * (n + 1) / 2

二分答案。
时间复杂度 O(nlogS)。其中 S = sum(nums[i])。
 */