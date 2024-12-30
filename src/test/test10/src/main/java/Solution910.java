import java.util.Arrays;

public class Solution910 {
    public int smallestRangeII(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        int ans = nums[len - 1] - nums[0];
        for (int i = 0; i + 1 < len; i++) {
            int max = Math.max(nums[len - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
/*
910. 最小差值 II
https://leetcode.cn/problems/smallest-range-ii/

给你一个整数数组 nums，和一个整数 k 。
对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
nums 的 分数 是 nums 中最大元素和最小元素的差值。
在更改每个下标对应的值之后，返回 nums 的最小 分数 。
提示：
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^4
0 <= k <= 10^4

贪心。
 */