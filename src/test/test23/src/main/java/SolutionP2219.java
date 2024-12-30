public class SolutionP2219 {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(ps[i + 1], ps[n] - ps[i]));
        }
        return ans;
    }
}
/*
$2219. 数组的最大总分
https://leetcode.cn/problems/maximum-sum-score-of-array/description/

给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。
nums 在下标 i （0 <= i < n）处的 总分 等于下面两个分数中的 最大值 ：
- nums 前 i + 1 个元素的总和
- nums 后 n - i 个元素的总和
返回数组 nums 在任一下标处能取得的 最大总分 。
提示：
n == nums.length
1 <= n <= 10^5
-10^5 <= nums[i] <= 10^5

前缀和 枚举。
 */