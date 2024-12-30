public class Solution3314 {
}
/*
3314. 构造最小位运算数组 I
https://leetcode.cn/problems/construct-the-minimum-bitwise-array-i/description/

第 141 场双周赛 T1。

给你一个长度为 n 的 质数 数组 nums 。你的任务是返回一个长度为 n 的数组 ans ，对于每个下标 i ，以下 条件 均成立：
- ans[i] OR (ans[i] + 1) == nums[i]
除此以外，你需要 最小化 结果数组里每一个 ans[i] 。
如果没法找到符合 条件 的 ans[i] ，那么 ans[i] = -1 。
质数 指的是一个大于 1 的自然数，且它只有 1 和自己两个因数。
提示：
1 <= nums.length <= 100
2 <= nums[i] <= 1000
nums[i] 是一个质数。

同: 3315. 构造最小位运算数组 II
https://leetcode.cn/problems/construct-the-minimum-bitwise-array-ii/description/
 */