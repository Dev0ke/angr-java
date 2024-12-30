public class Solution2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0, c0_1 = 0, c0_2 = 0;
        for (int x : nums1) {
            if (x == 0) {
                c0_1++;
            } else {
                s1 += x;
            }
        }
        for (int x : nums2) {
            if (x == 0) {
                c0_2++;
            } else {
                s2 += x;
            }
        }
        long up = Math.max(s1 + c0_1, s2 + c0_2);
        if (up > s1 && c0_1 == 0) return -1;
        if (up > s2 && c0_2 == 0) return -1;
        return up;
    }
}
/*
2918. 数组的最小相等和
https://leetcode.cn/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

第 369 场周赛 T2。

给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
提示：
1 <= nums1.length, nums2.length <= 10^5
0 <= nums1[i], nums2[i] <= 10^6

贪心。由于 0 要替换为正整数，因此最小也要替换为 1，求出最小上界，然后判断是否是合法解即可。
时间复杂度 O(n)
 */