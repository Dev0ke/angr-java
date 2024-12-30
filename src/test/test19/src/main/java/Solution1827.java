public class Solution1827 {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                // 差值增加 1 使其严格递增
                int between = nums[i - 1] - nums[i] + 1;
                nums[i] += between;
                cnt += between;
            }
        }
        return cnt;
    }
}
/*
1827. 最少操作使数组递增
https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/

第 50 场双周赛 T1。

给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
- 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
请你返回使 nums 严格递增 的 最少 操作次数。
我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。
一个长度为 1 的数组是严格递增的一种特殊情况。
提示：
1 <= nums.length <= 5000
1 <= nums[i] <= 10^4

模拟。
 */