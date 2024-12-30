import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        Deque<Integer> maxDq = new ArrayDeque<>(); // maxDq.getFirst() 为区间内最大值
        Deque<Integer> minDq = new ArrayDeque<>(); // minDq.getFirst() 为区间内最小值
        while (r < n) {
            while (!maxDq.isEmpty() && nums[r] > maxDq.getLast()) maxDq.removeLast();
            maxDq.addLast(nums[r]);
            while (!minDq.isEmpty() && nums[r] < minDq.getLast()) minDq.removeLast();
            minDq.addLast(nums[r]);

            while (!maxDq.isEmpty() && !minDq.isEmpty()
                    && maxDq.getFirst() - minDq.getFirst() > limit) {
                if (nums[l] == maxDq.getFirst()) maxDq.removeFirst();
                if (nums[l] == minDq.getFirst()) minDq.removeFirst();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
如果不存在满足条件的子数组，则返回 0 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9

不定长滑动窗口（求最长/最大）。单调队列。队列存放元素。
时间复杂度 O(n)
相似题目: 239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/
 */