import java.util.Arrays;

public class Solution3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 倒序枚举，第一个即为答案
        for (int k = 2; k >= 0; k--) {
            // 双指针 判断 子序列
            int n = nums1.length, m = nums2.length;
            int diff = nums2[0] - nums1[k];
            int i = k, j = 0, choice = 2 - k;
            while (j < m) {
                if (nums1[i] + diff == nums2[j]) {
                    i++;
                } else if (choice > 0) {
                    choice--;
                    i++;
                    continue;
                }
                j++;
            }
            if (i + choice == n) {
                return nums2[0] - nums1[k];
            }
        }
        // 题目保证答案一定存在
        return 996;
    }
}
/*
3132. 找出与数组相加的整数 II
https://leetcode.cn/problems/find-the-integer-added-to-array-ii/description/

第 395 场周赛 T2。

给你两个整数数组 nums1 和 nums2。
从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
返回能够实现数组相等的 最小 整数 x 。
提示：
3 <= nums1.length <= 200
nums2.length == nums1.length - 2
0 <= nums1[i], nums2[i] <= 1000
测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。

枚举 + 双指针。
枚举 nums1 保留的最小元素是 nums1[2]\nums1[1]\nums1[0]，同向双指针判断是否合法。
时间复杂度 O(nlogn)。
 */