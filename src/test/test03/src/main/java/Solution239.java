import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class Solution239 {
    // 单调队列 O(n)
    static class V1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> maxDq = new ArrayDeque<>(); // maxDq.getFirst() 为区间内最大值
            for (int i = 0; i < k; i++) {
                while (!maxDq.isEmpty() && nums[i] >= nums[maxDq.getLast()]) maxDq.removeLast();
                maxDq.addLast(i);
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[maxDq.getFirst()]);
            for (int i = k; i < n; i++) {
                while (!maxDq.isEmpty() && nums[i] >= nums[maxDq.getLast()]) maxDq.removeLast();
                maxDq.addLast(i);
                while (maxDq.getFirst() <= i - k) {
                    maxDq.removeFirst();
                }
                ans.add(nums[maxDq.getFirst()]);
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // 有序集合 O(nlogn)
    static class V2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;

            TreeSet<Integer> maxTreeSet = new TreeSet<>((o1, o2) -> {
                if (nums[o1] == nums[o2]) {
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(nums[o2], nums[o1]);
            });

            int[] res = new int[n - k + 1];
            // [0, k-1] 前 k 个
            for (int i = 0; i < k; i++) {
                maxTreeSet.add(i);
            }
            res[0] = nums[maxTreeSet.first()];

            // [k, n-1] 滑动窗口
            for (int i = k; i < n; i++) {
                // 先删后增
                maxTreeSet.remove(i - k);
                maxTreeSet.add(i);
                res[i - k + 1] = nums[maxTreeSet.first()];
            }
            return res;
        }
    }
}
/*
239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

单调队列。队列存放下标
时间复杂度 O(n)
相似题目: 1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */