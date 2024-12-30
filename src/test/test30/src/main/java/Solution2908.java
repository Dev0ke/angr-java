public class Solution2908 {
}
/*
2908. 元素和最小的山形三元组 I
https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/

第 368 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。
如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
- i < j < k
- nums[i] < nums[j] 且 nums[k] < nums[j]
请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
提示：
3 <= nums.length <= 50
1 <= nums[i] <= 50

同: 2909. 元素和最小的山形三元组 II
https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/description/
 */