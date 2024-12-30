public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        int cnt_0 = 0; // 0 的个数
        while (r < n) {
            if (nums[r] == 0) cnt_0++;
            if (cnt_0 > k) {
                if (nums[l] == 0) cnt_0--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/

第 126 场周赛 T3。

给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度。
输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
提示：
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1
0 <= k <= nums.length

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
相似题目: 2024. 考试的最大困扰度
https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
 */