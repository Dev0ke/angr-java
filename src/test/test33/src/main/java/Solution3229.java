public class Solution3229 {
    public long minimumOperations(int[] nums, int[] target) {
        int n = target.length;
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i] = target[i - 1] - nums[i - 1];
        }
        long ans = a[0];
        for (int i = 1; i < a.length; i++) {
            ans += Math.max(a[i] - a[i - 1], 0);
        }
        return ans;
    }
}
/*
3229. 使数组等于目标数组所需的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-array-equal-to-target/description/

第 407 场周赛 T4。

给你两个长度相同的正整数数组 nums 和 target。
在一次操作中，你可以选择 nums 的任何子数组，并将该子数组内的每个元素的值增加或减少 1。
返回使 nums 数组变为 target 数组所需的 最少 操作次数。
提示：
1 <= nums.length == target.length <= 10^5
1 <= nums[i], target[i] <= 10^8

差分。
两数组作差，前后补 0，然后同 1526 题。
时间复杂度 O(n)。
相似题目: 1526. 形成目标数组的子数组最少增加次数
https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 */