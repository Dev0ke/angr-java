public class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int mask1 = 0;
        int mask2 = 0;
        for (int x : nums1) {
            mask1 |= 1 << x;
        }
        for (int x : nums2) {
            mask2 |= 1 << x;
        }

        int and = mask1 & mask2;
        if (and != 0) {
            return Integer.numberOfTrailingZeros(and);
        }
        int x = Integer.numberOfTrailingZeros(mask1);
        int y = Integer.numberOfTrailingZeros(mask2);
        return Math.min(x * 10 + y, y * 10 + x);
    }
}
/*
2605. 从两个数字数组里生成最小数字
https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/

第 101 场双周赛 T1。

给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
提示：
1 <= nums1.length, nums2.length <= 9
1 <= nums1[i], nums2[i] <= 9
每个数组中，元素 互不相同 。

位运算
时间复杂度 O(n+m)
空间复杂度 O(1)
 */