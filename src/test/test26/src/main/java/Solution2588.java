public class Solution2588 {
    public long beautifulSubarrays(int[] nums) {
        long res = 0L;
        int sumMod2Mask = 0;
        int[] cnt = new int[1 << 20];
        cnt[0] = 1;
        for (int num : nums) {
            sumMod2Mask ^= num;
            res += cnt[sumMod2Mask];
            cnt[sumMod2Mask]++;
        }
        return res;
    }
}
/*
2588. 统计美丽子数组数目
https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/

第 336 场周赛 T3。

给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
- 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
- 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。
- 将 nums[i] 和 nums[j] 都减去 2k 。
如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
请你返回数组 nums 中 美丽子数组 的数目。
子数组是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^6

异或相当于模 2 下的加法
相似题目: 1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */