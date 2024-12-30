public class Solution3300 {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int v : nums) {
            ans = Math.min(ans, digitSum(v));
        }
        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
/*
3300. 替换为数位和以后的最小元素
https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum/description/

第 140 场双周赛 T1。

给你一个整数数组 nums 。
请你将 nums 中每一个元素都替换为它的各个数位之 和 。
请你返回替换所有元素以后 nums 中的 最小 元素。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 10^4

模拟。
时间复杂度 O(nlogU)。
 */