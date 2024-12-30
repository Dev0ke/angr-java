public class Solution3034 {
}
/*
3034. 匹配模式数组的子数组数目 I
https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-i/description/

第 384 场周赛 T2。

给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 -1 ，0 和 1 。
大小为 m + 1 的子数组 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 pattern ：
- 如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
- 如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
- 如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
请你返回匹配 pattern 的 nums 子数组的 数目 。
提示：
2 <= n == nums.length <= 100
1 <= nums[i] <= 10^9
1 <= m == pattern.length < n
-1 <= pattern[i] <= 1

同: 3036. 匹配模式数组的子数组数目 II
https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-ii/description/
 */