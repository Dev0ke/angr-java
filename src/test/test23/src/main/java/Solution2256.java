public class Solution2256 {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int min = Integer.MAX_VALUE;
        int minIdx = n - 1;
        // 如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
        for (int i = n - 1; i >= 0; i--) {
            long leftSum = preSum[i + 1] - preSum[0];
            long rightSum = preSum[n] - leftSum;

            int leftAvg = (int) (leftSum / (i + 1));
            int rightAvg = (n - i - 1 == 0) ? (int) rightSum : (int) (rightSum / (n - i - 1));

            int diff = Math.abs(leftAvg - rightAvg);
            if (diff <= min) {
                min = diff;
                minIdx = i;
            }
        }
        return minIdx;
    }
}
/*
2256. 最小平均差
https://leetcode.cn/problems/minimum-average-difference/

第 77 场双周赛 T2。

给你一个下标从 0 开始长度为 n 的整数数组 nums 。
下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。
请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
注意：
- 两个数的 绝对差 是两者差的绝对值。
- n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
- 0 个元素的平均值视为 0 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

前缀和 + 模拟。枚举每个下标，分别计算出前 i+1 个元数和后 n-i-1 个元素的平均值绝对差，需注意边界条件 n-i-1 为 0 的情况。
时间复杂度: O(n)
 */