public class Solution1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }
}
/*
1848. 到目标元素的最小距离
https://leetcode.cn/problems/minimum-distance-to-the-target-element/description/

给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
返回 abs(i - start) 。
题目数据保证 target 存在于 nums 中。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^4
0 <= start < nums.length
target 存在于 nums 中

模拟。枚举。
时间复杂度 O(n)。
 */