public class SolutionP2495 {
    public long evenProduct(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0] % 2 == 0 ? 1 : 0;
        int lastEven = nums[0] % 2 == 0 ? 0 : -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                lastEven = i;
            }
            dp[i] = dp[i - 1] + lastEven + 1;
        }
        return dp[n - 1];
    }
}
/*
$2495. 乘积为偶数的子数组数
https://leetcode.cn/problems/number-of-subarrays-having-even-product/description/

给定一个整数数组 nums，返回具有偶数乘积的 nums 子数组 的数目。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

dp[i] 表示结束下标不超过 i 的乘积为偶数的子数组的数目。
时间复杂度 O(n)。
 */