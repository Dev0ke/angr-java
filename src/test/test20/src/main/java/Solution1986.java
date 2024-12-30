import java.util.Arrays;

public class Solution1986 {
    public int minSessions(int[] tasks, int sessionTime) {
        // 1 <= n <= 14
        int n = tasks.length;

        // 状态压缩 2^14 = 16384
        boolean[] valid = new boolean[1 << n];
        for (int state = 0; state < (1 << n); state++) {
            int totalTime = 0;
            for (int k = 0; k < n; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    totalTime += tasks[k];
                }
            }
            valid[state] = totalTime <= sessionTime;
        }

        // 动态规划
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        // 初始状态
        dp[0] = 0;
        for (int state = 1; state < (1 << n); state++) {
            // 使用按位与运算在 O(1) 的时间快速得到下一个（即更小的）mask 的子集
            for (int subState = state; subState > 0; subState = (subState - 1) & state) {
                if (valid[subState]) {
                    // 补集
                    dp[state] = Math.min(dp[state], dp[state ^ subState] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
/*
1986. 完成任务的最少工作时间段
https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

第 256 场周赛 T3。

你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。
一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
你需要按照如下条件完成给定任务：
- 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
- 完成一个任务后，你可以 立马 开始一个新的任务。
- 你可以按 任意顺序 完成任务。
给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
提示：
n == tasks.length
1 <= n <= 14
1 <= tasks[i] <= 10
max(tasks[i]) <= sessionTime <= 15

枚举子集的动态规划
时间复杂度 O(3^n)
空间复杂度 O(2^n)
 */