public class SolutionP1746 {
    public int maxSumAfterOperation(int[] nums) {
        int len = nums.length;
        // dp0[i] 代表以第 i 个数结尾未经操作的「连续子数组的最大和」
        int[] dp0 = new int[len];
        // dp1[i] 代表以第 i 个数结尾经过操作的「连续子数组的最大和」
        int[] dp1 = new int[len];

        // 初始状态
        dp0[0] = Math.max(nums[0], 0);
        dp1[0] = nums[0] * nums[0];
        int max = dp1[0];

        // 状态转移
        for (int i = 1; i < len; i++) {
            dp0[i] = Math.max(Math.max(dp0[i - 1] + nums[i], nums[i]), 0);
            dp1[i] = Math.max(dp0[i - 1] + nums[i] * nums[i], dp1[i - 1] + nums[i]);
            max = Math.max(max, dp1[i]);
        }
        return max;
    }

    // 压缩
    public int maxSumAfterOperation2(int[] nums) {
        int len = nums.length;

        // 未替换
        int no = Math.max(0, nums[0]);
        // 替换
        int yes = nums[0] * nums[0];
        int maxSum = yes;
        for (int i = 1; i < len; i++) {
            yes = Math.max(no + nums[i] * nums[i], yes + nums[i]);
            no = Math.max(0, no + nums[i]);
            maxSum = Math.max(maxSum, yes);
        }
        return maxSum;
    }
}
/*
$1746. 经过一次操作后的最大子数组和
https://leetcode.cn/problems/maximum-subarray-sum-after-one-operation/

你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。
返回替换后的最大子数组和。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

动态规划。
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */