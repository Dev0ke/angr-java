public class Solution2640 {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] conver = getConver(nums, n);

        long[] res = new long[n];
        res[0] = conver[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + conver[i];
        }
        return res;
    }

    private long[] getConver(int[] nums, int n) {
        long[] conver = new long[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            conver[i] = max + nums[i];
        }
        return conver;
    }
}
/*
2640. 一个数组所有前缀的分数
https://leetcode.cn/problems/find-the-score-of-all-prefixes-of-an-array/

第 102 场双周赛 T2。

定义一个数组 arr 的 转换数组 conver 为：
- conver[i] = arr[i] + max(arr[0..i])，其中 max(arr[0..i]) 是满足 0 <= j <= i 的所有 arr[j] 中的最大值。
定义一个数组 arr 的 分数 为 arr 转换数组中所有元素的和。
给你一个下标从 0 开始长度为 n 的整数数组 nums ，请你返回一个长度为 n 的数组 ans ，其中 ans[i]是前缀 nums[0..i] 的分数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

模拟。
时间复杂度 O(n)
 */