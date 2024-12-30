import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;

        long[] preSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int min = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < preSum.length; i++) {
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && preSum[i] >= preSum[deque.getFirst()] + k) {
                min = Math.min(min, i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
/*
862. 和至少为 K 的最短子数组
https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/

给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
子数组 是数组中 连续 的一部分。
提示：
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
1 <= k <= 10^9

前缀和 + 滑动窗口
时间复杂度 O(n)
空间复杂度 O(n)
 */