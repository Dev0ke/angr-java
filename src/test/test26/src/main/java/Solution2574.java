public class Solution2574 {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;

        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = preSum[i];
            int rightSum = preSum[n] - preSum[i + 1];
            ans[i] = Math.abs(leftSum - rightSum);
        }
        return ans;
    }
}
/*
2574. 左右元素和的差值
https://leetcode.cn/problems/left-and-right-sum-differences/

第 334 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
- answer.length == nums.length
- answer[i] = |leftSum[i] - rightSum[i]|
其中：
- leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
- rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
返回数组 answer 。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^5

前缀和。leftSum[i] = [0,i-1] 区间和；rightSum[i] = [i+1,n-1] 区间和。
时间复杂度 O(n)
 */