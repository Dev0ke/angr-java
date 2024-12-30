public class SolutionP3173 {
    public int[] orArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ans[i] = nums[i] | nums[i + 1];
        }
        return ans;
    }
}
/*
$3173. 相邻元素的按位或
https://leetcode.cn/problems/bitwise-or-of-adjacent-elements/description/

给定一个长度为 n 的数组 nums，返回一个长度为 n - 1 的数组 answer 使得 answer[i] = nums[i] | nums[i + 1]，其中 | 表示按位 OR 操作。
提示：
2 <= nums.length <= 100
0 <= nums[i] <= 100

模拟。
 */