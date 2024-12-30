public class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        // dp0[i] 表示第 i 位不交换使得两个数组均保持严格递增状态的最小交换次数
        // dp1[i] 表示第 i 位交换使得两个数组均保持严格递增状态的最小交换次数
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];

        // 初始状态
        dp0[0] = 0;
        dp1[0] = 1;

        // 状态转移
        for (int i = 1; i < len; i++) {
            dp0[i] = Integer.MAX_VALUE;
            dp1[i] = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                // 不交换
                dp0[i] = dp0[i - 1];
                // “负负得正”
                dp1[i] = dp1[i - 1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp0[i] = Math.min(dp0[i], dp1[i - 1]);
                dp1[i] = Math.min(dp1[i], dp0[i - 1] + 1);
            }
        }
        return Math.min(dp0[len - 1], dp1[len - 1]);
    }
}
/*
801. 使序列递增的最小交换次数
https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/

我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
- 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
注意：
- 用例保证可以实现操作。
提示:
2 <= nums1.length <= 10^5
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 2 * 10^5

动态规划
时间复杂度 O(n)
空间复杂度 O(n) 可用滚动数组优化至 O(1)
 */