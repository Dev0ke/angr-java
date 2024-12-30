public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int v : nums) {
                c += (v >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
/*
477. 汉明距离总和
https://leetcode.cn/problems/total-hamming-distance/description/

两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。
提示：
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^9
给定输入的对应答案符合 32-bit 整数范围

拆位。逐位统计。
时间复杂度 O(nlogU)。其中 logU = 30.
 */