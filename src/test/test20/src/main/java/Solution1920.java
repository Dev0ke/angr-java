public class Solution1920 {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
/*
1920. 基于排列构建数组
https://leetcode.cn/problems/build-array-from-permutation/

第 248 场周赛 T1。

给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），
都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
提示：
1 <= nums.length <= 1000
0 <= nums[i] < nums.length
nums 中的元素 互不相同

ans[i] = nums[nums[i]
 */
