public class Solution2934 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans1 = getAns(nums1, nums2);
        int tmp = nums1[n - 1];
        nums1[n - 1] = nums2[n - 1];
        nums2[n - 1] = tmp;
        int ans2 = getAns(nums1, nums2) + 1;
        return Math.min(ans1, ans2);
    }

    private int getAns(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] <= nums1[n - 1] && nums2[i] <= nums2[n - 1]) continue;
            if (Math.max(nums1[i], nums2[i]) > Math.max(nums1[n - 1], nums2[n - 1])) return -1;
            if (Math.min(nums1[i], nums2[i]) > Math.min(nums1[n - 1], nums2[n - 1])) return -1;
            if (nums1[i] > nums1[n - 1] || nums2[i] > nums2[n - 1]) cnt++;
        }
        return cnt;
    }
}
/*
2934. 最大化数组末位元素的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-maximize-last-elements-in-arrays/description/

第 371 场周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，这两个数组的长度都是 n 。
你可以执行一系列 操作（可能不执行）。
在每次操作中，你可以选择一个在范围 [0, n - 1] 内的下标 i ，并交换 nums1[i] 和 nums2[i] 的值。
你的任务是找到满足以下条件所需的 最小 操作次数：
- nums1[n - 1] 等于 nums1 中所有元素的 最大值 ，即 nums1[n - 1] = max(nums1[0], nums1[1], ..., nums1[n - 1]) 。
- nums2[n - 1] 等于 nums2 中所有元素的 最大值 ，即 nums2[n - 1] = max(nums2[0], nums2[1], ..., nums2[n - 1]) 。
以整数形式，表示并返回满足上述 全部 条件所需的 最小 操作次数，如果无法同时满足两个条件，则返回 -1 。
提示：
1 <= n == nums1.length == nums2.length <= 1000
1 <= nums1[i] <= 10^9
1 <= nums2[i] <= 10^9

分类讨论
case1: 不交换 nums1[n-1]、nums2[n-1]
case2: 交换 nums1[n-1]、nums2[n-1]
时间复杂度 O(n)
 */