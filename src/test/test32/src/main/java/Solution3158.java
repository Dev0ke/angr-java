public class Solution3158 {
    public int duplicateNumbersXOR(int[] nums) {
        int[] cnt = new int[55];
        for (int v : nums) {
            cnt[v]++;
        }
        int xor = 0;
        for (int i = 1; i <= 50; i++) {
            if (cnt[i] == 2) {
                xor ^= i;
            }
        }
        return xor;
    }
}
/*
3158. 求出出现两次数字的 XOR 值
https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/

第 131 场双周赛 T1。

给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 50
nums 中每个数字要么出现过一次，要么出现过两次。

模拟。
时间复杂度 O(n)。
 */