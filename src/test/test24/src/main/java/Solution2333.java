import java.util.Arrays;

public class Solution2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(nums1[i] - nums2[i]);
        }

        long ans = 0, sum = 0, k = k1 + k2;
        for (long v : a) {
            sum += v;
            ans += v * v;
        }
        // 所有 a[i] 均可为 0
        if (sum <= k) return 0;

//        Arrays.sort(a);
//        for (int i = n; ; i--) {
//            int j = n - i + 1;
//            long v = a[i], c = j * (v - a[i - 1]);
        reverseSort(a);
        for (int i = 0; ; i++) {
            int j = i + 1;
            long v = a[i], c = j * (v - a[i + 1]);
            ans -= v * v;
            if (c < k) {
                k -= c;
                continue;
            }
            v -= k / j;
            // 有 k%j 个元素可以减少 k/(i+1) + 1
            // 有 j - k%j 个元素可以减少 k/(i+1)
            return ans + (k % j) * (v - 1) * (v - 1) + (j - k % j) * v * v;
        }
    }

    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
2333. 最小差值平方和
https://leetcode.cn/problems/minimum-sum-of-squared-difference/

第 82 场双周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度为 n 。
数组 nums1 和 nums2 的 差值平方和 定义为所有满足 0 <= i < n 的 (nums1[i] - nums2[i])2 之和。
同时给你两个正整数 k1 和 k2 。你可以将 nums1 中的任意元素 +1 或者 -1 至多 k1 次。类似的，你可以将 nums2 中的任意元素 +1 或者 -1 至多 k2 次。
请你返回修改数组 nums1 至多 k1 次且修改数组 nums2 至多 k2 次后的最小 差值平方和 。
注意：你可以将数组中的元素变成 负 整数。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 10^5
0 <= k1, k2 <= 10^9

贪心。优先处理差值绝对值较大的下标。
相似题目: 1648. 销售价值减少的颜色球
https://leetcode.cn/problems/sell-diminishing-valued-colored-balls/
 */