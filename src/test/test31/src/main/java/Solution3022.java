public class Solution3022 {
    public int minOrAfterOperations(int[] nums, int k) {
        int ans = 0;
        int mask = 0;
        for (int b = 30; b >= 0; b--) {
            mask |= 1 << b; // 屏蔽低位
            int cnt = 0;
            int and = -1;
            for (int x : nums) {
                and &= x & mask;
                if (and == 0) {
                    and = -1;
                } else {
                    cnt++;
                }
            }
            if (cnt > k) {
                ans |= 1 << b;
                mask ^= 1 << b; // 反悔
            }
        }
        return ans;
    }
}
/*
3022. 给定操作次数内使剩余元素的或值最小
https://leetcode.cn/problems/minimize-or-of-remaining-elements-using-operations/description/

第 382 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
一次操作中，你可以选择 nums 中满足 0 <= i < nums.length - 1 的一个下标 i ，并将 nums[i] 和 nums[i + 1] 替换为数字 nums[i] & nums[i + 1] ，其中 & 表示按位 AND 操作。
请你返回 至多 k 次操作以内，使 nums 中所有剩余元素按位 OR 结果的 最小值 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] < 2^30
0 <= k < nums.length

贪心 + 位运算。从高到低考虑
时间复杂度 O(nlogU)
rating 2945 (clist.by)
 */