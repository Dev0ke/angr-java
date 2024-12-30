public class Solution1955 {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int num : nums) {
            if (num == 0) {
                dp0 = (dp0 * 2 + 1) % mod;
            } else if (num == 1) {
                dp1 = (dp1 * 2 % mod + dp0) % mod;
            } else {
                dp2 = (dp2 * 2 % mod + dp1) % mod;
            }
        }
        return dp2;
    }
}
/*
1955. 统计特殊子序列的数目
https://leetcode.cn/problems/count-number-of-special-subsequences/

第 252 场周赛 T4。

特殊序列 是由 正整数 个 0 ，紧接着 正整数 个 1 ，最后 正整数 个 2 组成的序列。
- 比方说，[0,1,2] 和 [0,0,1,1,1,2] 是特殊序列。
- 相反，[2,1,0] ，[1] 和 [0,1,2,0] 就不是特殊序列。
给你一个数组 nums （仅 包含整数 0，1 和 2），请你返回 不同特殊子序列的数目 。由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
一个数组的 子序列 是从原数组中删除零个或者若干个元素后，剩下元素不改变顺序得到的序列。如果两个子序列的 下标集合 不同，那么这两个子序列是 不同的 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 2

动态规划，状态压缩后如诗一样优雅。
时间复杂度 O(n)
空间复杂度 O(1)
 */