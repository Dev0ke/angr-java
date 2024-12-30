import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;

        int left = 1;
        int right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(chargeTimes, runningCosts, budget, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // true: 可以连续运行 k 个机器人
    private boolean checkMid(int[] chargeTimes, int[] runningCosts, long budget, int k) {
        int n = chargeTimes.length;

        // 滑动窗口最大值
        Deque<Integer> deque = new ArrayDeque<>();
        long max = 0;
        long sum = 0;

        // 前 k 个
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && chargeTimes[i] >= chargeTimes[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            sum += runningCosts[i];
        }

        max = chargeTimes[deque.getFirst()];
        if (max + k * sum <= budget) {
            return true;
        }

        // k+1 到 len
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && chargeTimes[i] >= chargeTimes[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            max = chargeTimes[deque.getFirst()];
            sum = sum + runningCosts[i] - runningCosts[i - k];

            long totalCost = max + k * sum;
            if (totalCost <= budget) {
                return true;
            }
        }
        return false;
    }

    public int maximumRobots2(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> dq = new ArrayDeque<>();

        int max = 0;
        long sum = 0L;
        int l = 0, r = 0;
        while (r < n) {
            // 滑动窗口最大值
            while (!dq.isEmpty() && chargeTimes[r] > dq.getLast()) dq.removeLast();
            dq.addLast(chargeTimes[r]);
            sum += runningCosts[r];

            while (!dq.isEmpty() && dq.getFirst() + (r - l + 1) * sum > budget) {
                if (chargeTimes[l] == dq.getFirst()) dq.removeFirst();
                sum -= runningCosts[l];
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
/*
2398. 预算内的最多机器人数目
https://leetcode.cn/problems/maximum-number-of-robots-within-budget/

第 86 场双周赛 T4。

你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。
第 i 个机器人充电时间为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。
运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，
其中 max(chargeTimes) 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。
请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
提示：
chargeTimes.length == runningCosts.length == n
1 <= n <= 5 * 10^4
1 <= chargeTimes[i], runningCosts[i] <= 10^5
1 <= budget <= 10^15

二分 + 单调队列
单调队列维护区间最大值。
时间复杂度 O(nlogn)
相似题目: 239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/
 */