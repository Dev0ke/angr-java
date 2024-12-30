public class Solution2909 {
    private static final int INF = (int) 1e9;

    public int minimumSum(int[] nums) {
        int n = nums.length;

        // 前后缀分解
        int[] pre = new int[n];
        pre[0] = INF;
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i - 1]);
        }

        int[] suf = new int[n];
        suf[n - 1] = INF;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i + 1]);
        }

        int ans = INF;
        for (int i = 1; i <= n - 2; i++) {
            if (nums[i] > pre[i] && nums[i] > suf[i]) {
                ans = Math.min(ans, nums[i] + pre[i] + suf[i]);
            }
        }
        return ans == INF ? -1 : ans;
    }
}
/*
2909. 元素和最小的山形三元组 II
https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/description/

第 368 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。
如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
- i < j < k
- nums[i] < nums[j] 且 nums[k] < nums[j]
请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
提示：
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^8

前后缀分解
时间复杂度 O(n)
 */