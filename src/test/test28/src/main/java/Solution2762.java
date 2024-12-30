import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2762 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;

        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();

        int l = 0, r = 0;
        long ans = 0;
        while (r < n) {
            // 滑动窗口最大值
            while (!maxDq.isEmpty() && nums[r] > maxDq.getLast()) {
                maxDq.removeLast();
            }
            maxDq.addLast(nums[r]);
            // 滑动窗口最小值
            while (!minDq.isEmpty() && nums[r] < minDq.getLast()) {
                minDq.removeLast();
            }
            minDq.addLast(nums[r]);

            // 差值 > 2 时，左指针右移
            while (!maxDq.isEmpty() && !minDq.isEmpty()
                    && maxDq.getFirst() - minDq.getFirst() > 2) {
                if (nums[l] == maxDq.getFirst()) maxDq.removeFirst();
                if (nums[l] == minDq.getFirst()) minDq.removeFirst();
                l++;
            }

            ans += r - l + 1;
            r++;
        }

        return ans;
    }
}
/*
2762. 不间断子数组
https://leetcode.cn/problems/continuous-subarrays/

第 352 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。nums 的一个子数组如果满足以下条件，那么它是 不间断 的：
- i，i + 1 ，...，j  表示子数组中的下标。对于所有满足 i <= i1, i2 <= j 的下标对，都有 0 <= |nums[i1] - nums[i2]| <= 2 。
请你返回 不间断 子数组的总数目。
子数组是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

滑动窗口最大值、最小值
时间复杂度 O(n)
相似题目: 1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */