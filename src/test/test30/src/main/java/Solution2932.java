public class Solution2932 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    ans = Math.max(ans, nums[i] ^ nums[j]);
                }
            }
        }
        return ans;
    }
}
/*
2932. 找出强数对的最大异或值 I
https://leetcode.cn/problems/maximum-strong-pair-xor-i/description/

第 371 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ：
- |x - y| <= min(x, y)
你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。
返回数组 nums 所有可能的强数对中的 最大 异或值。
注意，你可以选择同一个整数两次来形成一个强数对。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 100

暴力
时间复杂度 O(n^2)
 */