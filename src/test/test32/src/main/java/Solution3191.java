public class Solution3191 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i + 2 < n; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i] ^ 1;
                nums[i + 1] = nums[i + 1] ^ 1;
                nums[i + 2] = nums[i + 2] ^ 1;
                ans++;
            }
        }
        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }
        return ans;
    }
}
/*
3191. 使二进制数组全部等于 1 的最少操作次数 I
https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/

第 133 场双周赛 T2。

给你一个二进制数组 nums 。
你可以对数组执行以下操作 任意 次（也可以 0 次）：
- 选择数组中 任意连续 3 个元素，并将它们 全部反转 。
反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
请你返回将 nums 中所有元素变为 1 的 最少 操作次数。如果无法全部变成 1 ，返回 -1 。
提示：
3 <= nums.length <= 10^5
0 <= nums[i] <= 1

模拟。
时间复杂度 O(n)。
 */