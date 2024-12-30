import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3049 {
    private int[] nums;
    private int[] changeIndices;
    private int[] first_t;

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        int n = nums.length;
        int m = changeIndices.length;
        if (n > m) return -1;

        // 慢速复习+考试所需天数
        long slow = n;
        for (int v : nums) {
            slow += v;
        }

        first_t = new int[n];
        Arrays.fill(first_t, -1);
        for (int t = m - 1; t >= 0; t--) {
            first_t[changeIndices[t] - 1] = t;
        }

        int left = n;
        int right = m + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(slow, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left > m ? -1 : left;
    }

    private boolean checkMid(long slow, int mx) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cnt = 0;
        for (int t = mx - 1; t >= 0; t--) {
            int i = changeIndices[t] - 1;
            int v = nums[i];
            if (v <= 1 || t != first_t[i]) {
                cnt++; // 留给左边，用来快速复习/考试
                continue;
            }
            if (cnt == 0) {
                if (heap.isEmpty() || v <= heap.peek()) {
                    cnt++; // 留给左边，用来快速复习/考试
                    continue;
                }
                slow += heap.remove() + 1;
                cnt += 2; // 反悔：一天快速复习，一天考试
            }
            slow -= v + 1;
            cnt--; // 快速复习，然后消耗一天来考试
            heap.add(v);
        }
        return cnt >= slow;
    }
}
/*
3049. 标记所有下标的最早秒数 II
https://leetcode.cn/problems/earliest-second-to-mark-indices-ii/description/

第 386 场周赛 T4。

给你两个下标从 1 开始的整数数组 nums 和 changeIndices ，数组的长度分别为 n 和 m 。
一开始，nums 中所有下标都是未标记的，你的任务是标记 nums 中 所有 下标。
从第 1 秒到第 m 秒（包括 第 m 秒），对于每一秒 s ，你可以执行以下操作 之一 ：
- 选择范围 [1, n] 中的一个下标 i ，并且将 nums[i] 减少 1 。
- 将 nums[changeIndices[s]] 设置成任意的 非负 整数。
- 选择范围 [1, n] 中的一个下标 i ， 满足 nums[i] 等于 0, 并 标记 下标 i 。
- 什么也不做。
请你返回范围 [1, m] 中的一个整数，表示最优操作下，标记 nums 中 所有 下标的 最早秒数 ，如果无法标记所有下标，返回 -1 。
提示：
1 <= n == nums.length <= 5000
0 <= nums[i] <= 10^9
1 <= m == changeIndices.length <= 5000
1 <= changeIndices[i] <= n

二分答案 + 反悔贪心
减一（慢速复习） => 随意复习
置 0（快速复习） => 涉及到 changeIndices
标记（考试）     => 参加任意一门考试
对于一门课程，要么全部用慢速复习，要么在某一天快速复习
倒着遍历，如果这一天不是快速复习，那么就和第三题一样，把 cnt+=1
如果遇到快速复习的那天
- 执行快速复习，消耗一天来考试（前提 cnt > 0）
- 不快速复习：
  1、nums[i] = 0
  2、nums[i] = 1
  3、cnt = 0 无法快速复习
     -> 难道就意味着这门课程一定要提前地用【慢速复习】搞定吗？
     -> 反悔贪心（反悔堆）
     -> 取一个原本用快速复习搞定的，且 nums[i] 最小的，反悔这门课程的用时（快速复习的一天+考试的一天）
     -> 多出来的这两天时间，用来做当前这门课程的快速复习+考试
时间复杂度 O(logn * mlogm)
rating 3123 (clist.by)
 */