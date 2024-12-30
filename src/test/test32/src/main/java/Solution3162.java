public class Solution3162 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int m = nums2.length;
        for (int i = 0; i < m; i++) {
            nums2[i] *= k;
        }
        int ans = 0;
        for (int x : nums1) {
            for (int y : nums2) {
                if (x % y == 0) ans++;
            }
        }
        return ans;
    }
}
/*
3162. 优质数对的总数 I
https://leetcode.cn/problems/find-the-number-of-good-pairs-i/description/

第 399 场周赛 T1。

给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
返回 优质数对 的总数。
提示：
1 <= n, m <= 50
1 <= nums1[i], nums2[j] <= 50
1 <= k <= 50

暴力。
相似题目: 3164. 优质数对的总数 II
https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/
 */