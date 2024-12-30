import java.util.Arrays;

public class Solution1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // f[i][j] 表示 nums1 前 i 个，nums2 前 j 个元素，可以得到的两个长度相同的非空子序列的最大点积
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], (int) -1e9);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];
                f[i][j] = prod;
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prod);
            }
        }
        return f[n][m];
    }
}
/*
1458. 两个子序列的最大点积
https://leetcode.cn/problems/max-dot-product-of-two-subsequences/description/

给你两个数组 nums1 和 nums2 。
请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
提示：
1 <= nums1.length, nums2.length <= 500
-1000 <= nums1[i], nums2[i] <= 100

动态规划。
时间复杂度 O(nm)。
 */