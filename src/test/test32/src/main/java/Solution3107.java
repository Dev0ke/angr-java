import java.util.Arrays;

public class Solution3107 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        int m = n / 2;
        int median = nums[m];
        if (median == k) return 0;
        int j = lowerBound(nums, k);
        if (median < k) {
            return (long) k * (j - m) - (ps[j] - ps[m]);
        }
        return (ps[m + 1] - ps[j]) - k * (m - j + 1L);
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3107. 使数组中位数等于 K 的最少操作数
https://leetcode.cn/problems/minimum-operations-to-make-median-of-array-equal-to-k/description/

第 392 场周赛 T3。

给你一个整数数组 nums 和一个 非负 整数 k 。一次操作中，你可以选择任一元素 加 1 或者减 1 。
请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。
一个数组的中位数指的是数组按非递减顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。
提示：
1 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9

排序 + 前缀和 + 二分查找。
时间复杂度 O(nlogn)
 */