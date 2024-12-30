public class Solution2317 {
    public int maximumXOR(int[] nums) {
        // 统计每位 1 的数量
        int[] cnt = new int[31];
        for (int num : nums) {
            for (int k = 0; k < 31; k++) {
                if (((num >> k) & 1) == 1) {
                    cnt[k]++;
                }
            }
        }

        // 只要该位 1 的数量不为 0，则可以取 1
        int res = 0;
        for (int k = 0; k < 31; k++) {
            if (cnt[k] > 0) {
                res += (1 << k);
            }
        }
        return res;
    }
}
/*
2317. 操作后的最大异或和
https://leetcode.cn/problems/maximum-xor-after-operations/

第 81 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。一次操作中，选择 任意 非负整数 x 和一个下标 i ，更新 nums[i] 为 nums[i] AND (nums[i] XOR x) 。
注意，AND 是逐位与运算，XOR 是逐位异或运算。
请你执行 任意次 更新操作，并返回 nums 中所有元素 最大 逐位异或和。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^8

位运算，贪心。
与运算：1 可以变 0，0 不可以变 1。
异或运算：如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
时间复杂度 O(n) 常数 31
 */