import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        // 中位数
        int median = nums[nums.length / 2];
        int cnt = 0;
        for (int num : nums) {
            cnt += Math.abs(num - median);
        }
        return cnt;
    }
}
/*
462. 最少移动次数使数组元素相等 II
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/

给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
提示：
n == nums.length
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

数学，中位数
时间复杂度 O(nlogn)
 */