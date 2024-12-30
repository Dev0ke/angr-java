import java.util.Arrays;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        System.arraycopy(nums, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int l = 0, r = n - 1;
        while (l <= r && nums[l] == sorted[l]) l++;
        while (l <= r && nums[r] == sorted[r]) r--;
        return r - l + 1;
    }
}
/*
581. 最短无序连续子数组
https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/

给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。
提示：
1 <= nums.length <= 10^4
-10^5 <= nums[i] <= 10^5

排序 + 双指针
时间复杂度 O(nlogn)
 */