public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        int n = merged.length;
        if (n % 2 == 1) return merged[n / 2];
        return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
    }

    // 合并两个有序数组
    private int[] merge(int[] a, int[] b) {
        int i = 0, n = a.length;
        int j = 0, m = b.length;
        int[] res = new int[n + m];
        int id = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) res[id++] = a[i++];
            else res[id++] = b[j++];
        }
        while (i < n) res[id++] = a[i++];
        while (j < m) res[id++] = b[j++];
        return res;
    }

    private int n, m;

    // 时间复杂度 O(log(m+n))
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        int tot = n + m;
        if (tot % 2 == 1) {
            return getKthElement(nums1, nums2, tot / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, tot / 2) + getKthElement(nums1, nums2, tot / 2 + 1)) / 2.0;
        }
    }

    // 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
    // 这里的 "/" 表示整除
    // nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
    // nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
    // 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
    // 这样 pivot 本身最大也只能是第 k-1 小的元素
    // 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
    // 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        while (true) {
            // 边界情况
            if (i == n) {
                return nums2[j + k - 1];
            }
            if (j == m) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(i + half, n) - 1;
            int newIndex2 = Math.min(j + half, m) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - i + 1);
                i = newIndex1 + 1;
            } else {
                k -= (newIndex2 - j + 1);
                j = newIndex2 + 1;
            }
        }
    }
}
/*
4. 寻找两个正序数组的中位数
https://leetcode.cn/problems/median-of-two-sorted-arrays/

给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6

合并两个数组后，中位的下标即为中位数。
时间复杂度 O(m+n)
空间复杂度 O(m+n)
 */