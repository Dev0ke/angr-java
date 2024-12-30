public class Solution3250 {
}
/*
3250. 单调数组对的数目 I
https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-i/description/

第 410 场周赛 T3。

给你一个长度为 n 的 正 整数数组 nums 。
如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：
- 两个数组的长度都是 n 。
- arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
- arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
- 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
请你返回所有 单调 数组对的数目。
由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= n == nums.length <= 2000
1 <= nums[i] <= 50

记忆化搜索。
时间复杂度 O(n^2 m) 可过。其中 m = 50
同: 3251. 单调数组对的数目 II
https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/description/
 */