public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int delta = nums[1] - nums[0];
        int ans = 0;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == delta) {
                cnt++;
            } else {
                delta = nums[i] - nums[i - 1];
                cnt = 0;
            }
            ans += cnt;
        }
        return ans;
    }
}
/*
413. 等差数列划分
https://leetcode.cn/problems/arithmetic-slices/

如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
- 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
子数组 是数组中的一个连续序列。
提示：
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

差分+计数。
时间复杂度 O(n)
空间复杂度 O(1)
 */