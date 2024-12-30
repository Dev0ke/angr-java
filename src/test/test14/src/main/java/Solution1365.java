public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = 101;
        int[] cntArr = new int[len];
        for (int num : nums) {
            cntArr[num]++;
        }

        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + cntArr[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preSum[nums[i]];
        }
        return res;
    }
}
/*
1365. 有多少小于当前数字的数字
https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/

给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。
提示：
2 <= nums.length <= 500
0 <= nums[i] <= 100

前缀和
时间复杂度 O(n)
 */