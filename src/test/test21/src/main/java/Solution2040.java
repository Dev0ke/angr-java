import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2040 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // -10^5 <= nums1[i], nums2[j] <= 10^5
        long left = (long) -1e11;
        long right = (long) 1e11;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums1, nums2, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 第 k 小的乘积为 lim，刚好存在 k-1 个小于 lim
    private boolean checkMid(int[] nums1, int[] nums2, long k, long lim) {
        long cnt = 0;
        // 枚举 num1，二分判断 nums2 有多少个数满足 num1*num2 <= lim
        // 对 num1 > 0, num1 < 0, num1 == 0 分类讨论
        for (long num1 : nums1) {
            if (num1 > 0) {
                if (num1 * nums2[0] > lim) {
                    continue;
                }
                int left = 0;
                int right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    if (num1 * nums2[mid] > lim) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                cnt += left;
            } else if (num1 < 0) {
                if (num1 * nums2[nums2.length - 1] > lim) {
                    continue;
                }
                int left = 0;
                int right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    if (num1 * nums2[mid] <= lim) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                cnt += nums2.length - left;
            } else if (lim >= 0) {
                cnt += nums2.length;
            }
        }
        return cnt >= k;
    }

    // 时间复杂度 O(n^2) TLE
    public long kthSmallestProduct2(int[] nums1, int[] nums2, long k) {
        List<Long> list = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                list.add((long) num1 * num2);
            }
        }
        Collections.sort(list);
        return list.get((int) (k - 1));
    }
}
/*
2040. 两个有序数组的第 K 小乘积
https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/

第 63 场双周赛 T4。

给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，
请你返回第 k （从 1 开始编号）小的 nums1[i] * nums2[j] 的乘积，其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
提示：
1 <= nums1.length, nums2.length <= 5 * 10^4
-10^5 <= nums1[i], nums2[j] <= 10^5
1 <= k <= nums1.length * nums2.length
nums1 和 nums2 都是从小到大排好序的。

二分套二分。时间复杂度 O(nloglogn)
直接 PriorityQueue 会 TLE，题目提示整数数组 nums1 和 nums2 从小到大排好序，考虑二分。
由于存在负数，需要分情况讨论，如果全为整数，则是单纯的 “杨氏矩阵” https://oi-wiki.org/math/young-tableau/
相似题目: 240. 搜索二维矩阵 II
https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */