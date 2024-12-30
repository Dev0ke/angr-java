public class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = i * nums[i] - ps[i];
            int r = (ps[n] - ps[i + 1]) - nums[i] * (n - 1 - i);
            ans[i] = l + r;
        }
        return ans;
    }
}
/*
1685. 有序数组中差绝对值之和
https://leetcode.cn/problems/sum-of-absolute-differences-in-a-sorted-array/description/

给你一个 非递减 有序整数数组 nums 。
请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= nums[i + 1] <= 10^4

前缀和。
时间复杂度 O(n)。
 */