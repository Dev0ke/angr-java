public class Solution3254 {
}
/*
3254. 长度为 K 的子数组的能量值 I
https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-i/description/

第 137 场双周赛 T1。

给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
一个数组的 能量值 定义为：
- 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
- 否则为 -1 。
你需要求出 nums 中所有长度为 k 的 子数组 的能量值。
请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
提示：
1 <= n == nums.length <= 500
1 <= nums[i] <= 10^5
1 <= k <= n

同: 3255. 长度为 K 的子数组的能量值 II
https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/description/
 */