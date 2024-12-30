import java.util.Arrays;

public class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums1.length;

        // 长度差超过 6 倍时，无解
        if (len1 * 6 < len2 || len2 * 6 < len1) {
            return -1;
        }

        // 偏序（使 sum(nums1) < sum(nums2)，将 nums1[i] 变 6，nums2[i] 变 1）
        int diff = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();
        if (diff < 0) {
            diff = -diff;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        // 统计每个数变化量
        int[] cnt = new int[6];
        // nums1[i] 变 6
        for (int num : nums1) {
            cnt[6 - num]++;
        }
        // nums2[i] 变 1
        for (int num : nums2) {
            cnt[num - 1]++;
        }

        int res = 0;
        // 从大到小枚举最大变化量 5 4 3 2 1
        for (int x = 5; x >= 0; x--) {
            if (x * cnt[x] < diff) {
                res += cnt[x];
                diff -= x * cnt[x];
            } else {
                // 数论向上取整法
                res += (diff + x - 1) / x;
                return res;
            }
        }
        return -1;
    }
}
/*
1775. 通过最少操作次数使数组的和相等
https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/

给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
提示：
1 <= nums1.length, nums2.length <= 10^5
1 <= nums1[i], nums2[i] <= 6

将两个数组进行偏序处理可以简化代码编写难道，我们使 sum(nums1) < sum(nums2)；
贪心思想。当 sum(nums1) < sum(nums2) 时，nums1[i] 应该尽可能变大(变成 6)，nums2[i] 应该尽可能变小(变成 1)。
统计各种变化量的个数，其中 cnt[x] = k 表示可使 diff 减少 k 个 x；
从大到小（5-4-3-2-1）枚举 x。如果 x * cnt[x] < diff，则可全部选取；否则可通过选取 ceil(diff / x) 个使 diff = 0。
时间复杂度 O(m+n)
空间复杂度 O(1) 其中常数为 6
 */