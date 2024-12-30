public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // 特判
        int n = nums.length, l = 0, r = 0, ans = 0;
        long prod = 1;
        while (r < n) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
/*
713. 乘积小于K的子数组
https://leetcode.cn/problems/subarray-product-less-than-k/

给定一个正整数数组 nums和整数 k 。
请找出该数组内乘积小于 k 的连续的子数组的个数。
提示:
1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6

双指针
时间复杂度 O(n)
相似题目: 209. 长度最小的子数组
https://leetcode.cn/problems/minimum-size-subarray-sum/
 */