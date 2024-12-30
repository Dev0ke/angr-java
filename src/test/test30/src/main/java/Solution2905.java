public class Solution2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int max = 0, maxI = 0, min = (int) 1e9, minI = 0;
        for (int i = 0; i + indexDifference < n; i++) {
            int j = i + indexDifference;
            if (max < nums[i]) {
                max = nums[i];
                maxI = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minI = i;
            }
            if (max - nums[j] >= valueDifference) {
                return new int[]{maxI, j};
            }
            if (nums[j] - min >= valueDifference) {
                return new int[]{minI, j};
            }
        }
        return new int[]{-1, -1};
    }
}
/*
2905. 找出满足差值条件的下标 II
https://leetcode.cn/problems/find-indices-with-index-and-value-difference-ii/description/

第 367 场周赛 T3。

给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。
你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
- abs(i - j) >= indexDifference 且
- abs(nums[i] - nums[j]) >= valueDifference
返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
注意：i 和 j 可能 相等 。
提示：
1 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= indexDifference <= 10^5
0 <= valueDifference <= 10^9

记录 前缀最小值、最大值。
时间复杂度 O(n)
 */