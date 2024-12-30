public class Solution2997 {
    public int minOperations(int[] nums, int k) {
        int[] bits = new int[30];
        for (int i = 0; i < 30; i++) {
            for (int x : nums) {
                if ((x >> i & 1) == 1) {
                    bits[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            if ((k >> i & 1) != (bits[i] & 1)) {
                ans++;
            }
        }
        return ans;
    }

    public int minOperations2(int[] nums, int k) {
        int xor = 0;
        for (int v : nums) {
            xor ^= v;
        }
        xor ^= k;
        return Integer.bitCount(xor);
    }
}
/*
2997. 使数组异或和等于 K 的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/

第 121 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。
你可以对数组执行以下操作 任意次 ：
- 选择数组里的 任意 一个元素，并将它的 二进制 表示 翻转 一个数位，翻转数位表示将 0 变成 1 或者将 1 变成 0 。
你的目标是让数组里 所有 元素的按位异或和得到 k ，请你返回达成这一目标的 最少 操作次数。
注意，你也可以将一个数的前导 0 翻转。比方说，数字 (101)2 翻转第四个数位，得到 (1101)2 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^6
0 <= k <= 10^6

拆位
时间复杂度 O(n)
 */