public class Solution2903 {
}
/*
2903. 找出满足差值条件的下标 I
https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/description/

第 367 场周赛 T1。

给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。
你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
- abs(i - j) >= indexDifference 且
- abs(nums[i] - nums[j]) >= valueDifference
返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
注意：i 和 j 可能 相等 。
提示：
1 <= n == nums.length <= 100
0 <= nums[i] <= 50
0 <= indexDifference <= 100
0 <= valueDifference <= 50

同: 2905. 找出满足差值条件的下标 II
https://leetcode.cn/problems/find-indices-with-index-and-value-difference-ii/description/
 */