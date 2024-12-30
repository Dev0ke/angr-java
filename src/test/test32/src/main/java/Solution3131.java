import java.util.Arrays;

public class Solution3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        int mn1 = Arrays.stream(nums1).min().orElseThrow();
        int mn2 = Arrays.stream(nums2).min().orElseThrow();
        return mn2 - mn1;
    }
}
/*
3131. 找出与数组相加的整数 I
https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/

第 395 场周赛 T1。

给你两个长度相等的数组 nums1 和 nums2。
数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
返回整数 x 。
提示：
1 <= nums1.length == nums2.length <= 100
0 <= nums1[i], nums2[i] <= 1000
测试用例以这样的方式生成：存在一个整数 x，使得 nums1 中的每个元素都与 x 相加后，nums1 与 nums2 相等。

求两个数组最小值的差值即可。
时间复杂度 O(n)。
 */