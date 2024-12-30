import java.util.Arrays;

public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, l = 0, r = 0, maxLen = 0;
        int delta = Arrays.stream(nums).sum() - x;
        // 注意特判
        if (delta < 0) return -1;
        if (delta == 0) return n;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > delta) {
                sum -= nums[l];
                l++;
            }
            if (sum == delta) maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        // delta > 0 但删除元素个数为 0，说明无解
        return maxLen == 0 ? -1 : n - maxLen;
    }
}
/*
1658. 将 x 减到 0 的最小操作数
https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/

给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
1 <= x <= 10^9

不定长滑动窗口（求最长/最大）。
问题等价于 nums.length 减去 窗口内元素为`sum(nums)-x`的最长长度。
时间复杂度 O(n)
 */