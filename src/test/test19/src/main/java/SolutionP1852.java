public class SolutionP1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length, diff = 0;
        int[] mp = new int[100005]; // 统计元素及元素出现的次数
        for (int i = 0; i < k; i++) {
            if (++mp[nums[i]] == 1) diff++;
        }
        int[] ans = new int[n - k + 1];
        ans[0] = diff;
        for (int i = k; i < n; i++) {
            if (--mp[nums[i - k]] == 0) diff--;
            if (++mp[nums[i]] == 1) diff++;
            ans[i - k + 1] = diff;
        }
        return ans;
    }
}
/*
$1852. 每个子数组的数字种类数
https://leetcode.cn/problems/distinct-numbers-in-each-subarray/description/

给你一个整数数组 nums与一个整数 k，请你构造一个长度 n-k+1 的数组 ans，这个数组第i个元素 ans[i] 是每个长度为k的子数组 nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]]中数字的种类数。
返回这个数组 ans。
提示:
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^5

固定大小的滑动窗口。
时间复杂度 O(n)。
 */