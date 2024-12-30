import java.util.Arrays;

public class Solution2419 {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();

        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == max) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
/*
2419. 按位与最大的最长子数组
https://leetcode.cn/problems/longest-subarray-with-maximum-bitwise-and/

第 312 场周赛 T2。

给你一个长度为 n 的整数数组 nums 。
考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
- 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
返回满足要求的 最长 子数组的长度。
数组的按位与就是对数组中的所有数字进行按位与运算。
子数组 是数组中的一个连续元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

问题等价于查找最大数的最长连续子数组长度。
时间复杂度 O(n)
 */