public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // dp[i][j] 表示 nums1[0:i-1] 长度 i 与 nums2[0:j-1] 长度 j 的最长公共子序列的长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= len2; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
1035. 不相交的线
https://leetcode.cn/problems/uncrossed-lines/

第 134 场周赛 T3。

在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
- nums1[i] == nums2[j]
- 且绘制的直线不与任何其他连线（非水平线）相交。
请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
以这种方法绘制线条，并返回可以绘制的最大连线数。
提示：
1 <= nums1.length, nums2.length <= 500
1 <= nums1[i], nums2[j] <= 2000

LCS
相似题目: 1143 最长公共子序列
https://leetcode.cn/problems/longest-common-subsequence/
 */