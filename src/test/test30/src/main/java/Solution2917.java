public class Solution2917 {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
/*
2917. 找出数组中的 K-or 值
https://leetcode.cn/problems/find-the-k-or-of-an-array/

第 369 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
nums 中的 K-or 是一个满足以下条件的非负整数：
- 只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
返回 nums 的 K-or 值。
注意 ：对于整数 x ，如果 (2i AND x) == 2^i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
提示：
1 <= nums.length <= 50
0 <= nums[i] < 2^31
1 <= k <= nums.length

拆位 模拟
时间复杂度 O(nlogU)
 */