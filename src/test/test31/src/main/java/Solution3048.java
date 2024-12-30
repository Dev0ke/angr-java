import java.util.Arrays;

public class Solution3048 {
    private int[] nums;
    private int[] changeIndices;

    // CF732D
    // nums[i] 当作第 i 门课程需要 nums[i] 天复习
    // changeIndices[t] 表示在第 t 天，第 changeIndices[t] 门课程可以考试，考试那天是不能复习的
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        int n = nums.length;
        int m = changeIndices.length;
        if (n > m) return -1;

        int left = n - 1;
        int right = m + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int ans = left;
        return ans > m ? -1 : ans;
    }

    private boolean checkMid(int mx) {
        int[] last_t = new int[nums.length];
        Arrays.fill(last_t, -1);
        for (int t = 0; t < mx; t++) {
            last_t[changeIndices[t] - 1] = t;
        }
        // 有课程没有考试时间
        for (int v : last_t) {
            if (v == -1) {
                return false;
            }
        }

        int cnt = 0;
        for (int t = 0; t < mx; t++) {
            int idx = changeIndices[t] - 1;
            // 一定要考试
            if (t == last_t[idx]) {
                // 没时间复习
                if (nums[idx] > cnt) return false;
                // 复习这门课
                cnt -= nums[idx];
            } else {
                // 留着后面用
                cnt++;
            }
        }
        return true;
    }
}
/*
3048. 标记所有下标的最早秒数 I
https://leetcode.cn/problems/earliest-second-to-mark-indices-i/description/

第 386 场周赛 T3。

给你两个下标从 1 开始的整数数组 nums 和 changeIndices ，数组的长度分别为 n 和 m 。
一开始，nums 中所有下标都是未标记的，你的任务是标记 nums 中 所有 下标。
从第 1 秒到第 m 秒（包括 第 m 秒），对于每一秒 s ，你可以执行以下操作 之一 ：
- 选择范围 [1, n] 中的一个下标 i ，并且将 nums[i] 减少 1 。
- 如果 nums[changeIndices[s]] 等于 0 ，标记 下标 changeIndices[s] 。
- 什么也不做。
请你返回范围 [1, m] 中的一个整数，表示最优操作下，标记 nums 中 所有 下标的 最早秒数 ，如果无法标记所有下标，返回 -1 。
提示：
1 <= n == nums.length <= 2000
0 <= nums[i] <= 10^9
1 <= m == changeIndices.length <= 2000
1 <= changeIndices[i] <= n

二分答案
时间复杂度 O(mlogm)
 */