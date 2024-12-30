public class Solution2871 {
    public int maxSubarrays(int[] nums) {
        int ands = -1;
        for (int x : nums) {
            ands &= x;
        }
        if (ands > 0) return 1;
        int ans = 0;
        ands = -1;
        for (int x : nums) {
            ands &= x;
            if (ands == 0) {
                ans++;
                ands = -1;
            }
        }
        return ans;
    }
}
/*
2871. 将数组分割成最多数目的子数组
https://leetcode.cn/problems/split-array-into-maximum-number-of-subarrays/description/

第 114 场双周赛 T3。

给你一个只包含 非负 整数的数组 nums 。
我们定义满足 l <= r 的子数组 nums[l..r] 的分数为 nums[l] AND nums[l + 1] AND ... AND nums[r] ，其中 AND 是按位与运算。
请你将数组分割成一个或者更多子数组，满足：
- 每个 元素都 只 属于一个子数组。
- 子数组分数之和尽可能 小 。
请你在满足以上要求的条件下，返回 最多 可以得到多少个子数组。
一个 子数组 是一个数组中一段连续的元素。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^6

AND运算性质
时间复杂度 O(n)
 */