public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i];
            ans[i + len] = nums[i];
        }
        return ans;
    }
}
/*
1929. 数组串联
https://leetcode.cn/problems/concatenation-of-array/

第 249 场周赛 T1。

给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
- ans[i] == nums[i]
- ans[i + n] == nums[i]
具体而言，ans 由两个 nums 数组 串联 形成。
返回数组 ans 。
提示：
n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000

模拟。
 */