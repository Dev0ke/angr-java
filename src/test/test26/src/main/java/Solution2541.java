import java.util.Arrays;

public class Solution2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        // 特判
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }

        int n = nums1.length;
        long add = 0;
        long sub = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] < nums2[i]) {
                int d = nums2[i] - nums1[i];
                if (d % k != 0) {
                    return -1;
                } else {
                    add += d / k;
                }
            } else if (nums1[i] > nums2[i]) {
                int d = nums1[i] - nums2[i];
                if (d % k != 0) {
                    return -1;
                } else {
                    sub += d / k;
                }
            }
        }
        return add == sub ? add : -1;
    }
}
/*
2541. 使数组中所有元素相等的最小操作数 II
https://leetcode.cn/problems/minimum-operations-to-make-array-equal-ii/

第 96 场双周赛 T2。

给你两个整数数组 nums1 和 nums2 ，两个数组长度都是 n ，再给你一个整数 k 。你可以对数组 nums1 进行以下操作：
- 选择两个下标 i 和 j ，将 nums1[i] 增加 k ，将 nums1[j] 减少 k 。换言之，nums1[i] = nums1[i] + k 且 nums1[j] = nums1[j] - k 。
如果对于所有满足 0 <= i < n 都有 num1[i] == nums2[i] ，那么我们称 nums1 等于 nums2 。
请你返回使 nums1 等于 nums2 的 最少 操作数。如果没办法让它们相等，请你返回 -1 。
提示：
n == nums1.length == nums2.length
2 <= n <= 10^5
0 <= nums1[i], nums2[j] <= 10^9
0 <= k <= 10^5

模拟，判断加和减的次数是否相等。
注意 RE java.lang.ArithmeticException: / by zero
 */