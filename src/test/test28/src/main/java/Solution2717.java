public class Solution2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int ans = minIdx + (n - 1 - maxIdx);
        return minIdx < maxIdx ? ans : ans - 1;
    }
}
/*
2717. 半有序排列
https://leetcode.cn/problems/semi-ordered-permutation/

第 348 场周赛 T2。

给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
- 选择 nums 中相邻的两个元素，然后交换它们。
返回使 nums 变成 半有序排列 所需的最小操作次数。
排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
提示：
2 <= nums.length == n <= 50
1 <= nums[i] <= 50
nums 是一个 排列

分类讨论。找出最小值，最大值坐标后：
ans = 0 下标已归位
ans = i + (n-1-i) 下标不交叉
ans = i + (n-1-i) -1 下标交叉
时间复杂度 O(n)
 */