public class SolutionP3269 {
    public int minLargest(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1]; // dp[i][j]: 对nums1的前i个数和nums2的前j个数操作，最小的最大可达数字
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) continue;
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (nums1[i - 1] % 2 == dp[i - 1][j] % 2 ? 2 : 1));
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + (nums2[j - 1] % 2 == dp[i][j - 1] % 2 ? 2 : 1));
            }
        }
        return dp[n1][n2];
    }
}
/*
$3269. 构建两个递增数组
https://leetcode.cn/problems/constructing-two-increasing-arrays/description/

给定两个只包含 0 和 1 的整数数组 nums1 和 nums2，你的任务是执行下面操作后使数组 nums1 和 nums2 中 最大 可达数字 尽可能小。
将每个 0 替换为正偶数，将每个 1 替换为正奇数。在替换后，两个数组都应该 递增 并且每个整数 至多 被使用一次。
返回执行操作后最小的最大可达数字。
提示：
0 <= nums1.length <= 1000
1 <= nums2.length <= 1000
nums1 和 nums2 只包含 0 和 1。

各种贪心思路都很容易找到反例，结合数据范围，不难想到应该用动态规划来解决。状态定义为dp[i][j]为nums1填上前i个元素，nums2填上前j个元素（i和j可以为0，表示这个数组没填过）时，已填好的最大元素的最小可能值。不妨设填数过程是把所有正整数从小到大穿插填入两个数组里的（就像各种错误的贪心模拟那样），dp[i][j][0]与dp[i][j][1]分别对应最后一个元素填在nums1与nums2时，这个元素的最小值，因此dp[i][j][0]只能由dp[i-1][j]转移而来，dp[i][j][1]只能由dp[i][j-1]转移而来，如果这点不能想明白，就只能坐牢了。
这道题的边界条件看上去相当棘手，dp[i][0][1]与dp[0][j][0]逻辑上是非法状态，dp[0][1][1]是和nums2[0]相关的一个边界状态，dp[1][0][0]在nums1不为空时也是一个边界状态，但输入允许nums1为空。一个较难理解，但实现上不易出错的做法是规定dp[0][0][0]=dp[0][0][1]=0，而在状态转移过程中，i和j都是从0开始循环，但i=0时跳过dp[i][j][0]，j=0时跳过dp[i][j][1]。最终答案为dp[m][n][0]和dp[m][n][1]中较小的一个。
当前状态与上一个状态匹配时，不难发现上一个状态值与当前填的元素奇偶性相同时需要+2，否则+1，这可以用位运算的异或来避免冗长的if-else。
https://leetcode.cn/problems/constructing-two-increasing-arrays/solutions/2896998/shuang-xu-lie-dpbian-jie-hen-yi-cuo-by-7-3eho/
 */