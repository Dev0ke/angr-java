import java.util.Arrays;

public class Solution1589 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // 补 0, 防下标越界
        for (int[] p : requests) {
            int l = p[0], r = p[1];
            diff[l]++;
            diff[r + 1]--;
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        Arrays.sort(diff);
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long prod = (long) nums[i] * diff[i + 1]; // 补 0, 防下标越界
            ans = (ans + prod) % MOD;
        }
        return (int) ans;
    }
}
/*
1589. 所有排列中的最大和
https://leetcode.cn/problems/maximum-sum-obtained-of-any-permutation/description/

有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
由于答案可能会很大，请你将它对 10^9 + 7 取余 后返回。
提示：
n == nums.length
1 <= n <= 10^5
0 <= nums[i] <= 10^5
1 <= requests.length <= 10^5
requests[i].length == 2
0 <= starti <= endi < n

差分 + 贪心。
时间复杂度 O(nlogn)。
 */