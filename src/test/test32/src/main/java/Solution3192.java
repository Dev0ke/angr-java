public class Solution3192 {
    public int minOperations(int[] nums) {
        int pre = 1;
        int ans = 0;
        for (int v : nums) {
            if (v != pre) {
                ans++;
                pre = v;
            }
        }
        return ans;
    }
}
/*
3192. 使二进制数组全部等于 1 的最少操作次数 II
https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/

第 133 场双周赛 T3。

给你一个二进制数组 nums 。
你可以对数组执行以下操作 任意 次（也可以 0 次）：
- 选择数组中 任意 一个下标 i ，并将从下标 i 开始一直到数组末尾 所有 元素 反转 。
反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
请你返回将 nums 中所有元素变为 1 的 最少 操作次数。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 1

奇偶性质。
时间复杂度 O(n)。
相似题目: 1529. 最少的后缀翻转次数
https://leetcode.cn/problems/minimum-suffix-flips/description/
 */