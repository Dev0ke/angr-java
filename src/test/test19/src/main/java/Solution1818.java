import java.util.Arrays;

public class Solution1818 {
    private static final int MOD = (int) (1e9 + 7);

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // 拷贝排序 nums1
        int[] sortedNums1 = new int[n];
        System.arraycopy(nums1, 0, sortedNums1, 0, n);
        Arrays.sort(sortedNums1);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int absDiff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + absDiff) % MOD;

            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (sortedNums1[mid] >= nums2[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            // nums[left] <= nums2[i] <= nums[left]
            if (left < n) {
                max = Math.max(max, absDiff - (sortedNums1[left] - nums2[i]));
            }
            if (left - 1 >= 0) {
                max = Math.max(max, absDiff - (nums2[i] - sortedNums1[left - 1]));
            }
        }
        return (sum - max + MOD) % MOD;
    }
}
/*
1818. 绝对差值和
https://leetcode.cn/problems/minimum-absolute-sum-difference/

给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
|x| 定义为：
- 如果 x >= 0 ，值为 x ，或者
- 如果 x <= 0 ，值为 -x
提示：
n == nums1.length
n == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 10^5

枚举每个 i，在 nums1 中二分求最接近 nums2[i] 的数。结果减去它们的最大值。
 */