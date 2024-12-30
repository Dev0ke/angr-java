public class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
        }
        return ans;
    }
}
/*
1470. 重新排列数组
https://leetcode.cn/problems/shuffle-the-array/description/

给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
提示：
1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3

模拟。
时间复杂度 O(n)。
 */