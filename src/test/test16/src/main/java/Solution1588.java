public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            // 注意等号
            for (int j = 1; i + j <= len; j += 2) {
                int endIdx = i + j - 1;
                sum += preSum[endIdx + 1] - preSum[i];
            }
        }
        return sum;
    }
}
/*
1588. 所有奇数长度子数组的和
https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/

给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
子数组 定义为原数组中的一个连续子序列。
请你返回 arr 中 所有奇数长度子数组的和 。
提示：
1 <= arr.length <= 100
1 <= arr[i] <= 1000

本题数据量可用 前缀和
时间复杂度 O(n^2)
还有 O(n) 的数学解法。
 */