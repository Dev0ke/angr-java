public class Solution2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n % 2 == 1 && m % 2 == 1) {
            return xorAllNums(nums2) ^ xorAllNums(nums1);
        } else if (n % 2 == 1) {
            return xorAllNums(nums2);
        } else if (m % 2 == 1) {
            return xorAllNums(nums1);
        } else {
            return 0;
        }
    }

    private int xorAllNums(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
/*
2425. 所有数对的异或和
https://leetcode.cn/problems/bitwise-xor-of-all-pairings/

第 88 场双周赛 T3。

给你两个下标从 0 开始的数组 nums1 和 nums2 ，两个数组都只包含非负整数。
请你求出另外一个数组 nums3 ，包含 nums1 和 nums2 中 所有数对 的异或和（nums1 中每个整数都跟 nums2 中每个整数 恰好 匹配一次）。
请你返回 nums3 中所有整数的 异或和 。
提示：
1 <= nums1.length, nums2.length <= 10^5
0 <= nums1[i], nums2[j] <= 10^9

贪心。如果 nums1 的元素个数为偶数，那么 nums2 每个元素出现次数同样为偶数，根据 a^b^b=a 性质得，同一个数偶数次异或并不影响结果。因此只考虑奇数次情况即可。
时间复杂度 O(n + m) 最坏情况时，结果为所有数的异或和。
 */