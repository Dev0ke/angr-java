import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;

        int[][] f = new int[d][n];
        f[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            f[0][i] = Math.max(f[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            Deque<int[]> st = new ArrayDeque<>(); // (下标 j，从 f[i-1][left[j]] 到 f[i-1][j-1] 的最小值)
            for (int j = i; j < n; j++) {
                int mn = f[i - 1][j - 1]; // 只有 a[j] 一项工作
                while (!st.isEmpty() && jobDifficulty[st.peek()[0]] <= jobDifficulty[j]) { // 向左一直计算到 left[j]
                    mn = Math.min(mn, st.pop()[1]);
                }
                f[i][j] = mn + jobDifficulty[j]; // 从 a[left[j]+1] 到 a[j] 的最大值是 a[j]
                if (!st.isEmpty()) { // 如果这一段包含 <=left[j] 的工作，那么这一段的最大值必然不是 a[j]
                    f[i][j] = Math.min(f[i][j], f[i][st.peek()[0]]); // 答案和 f[i][left[j]] 是一样的
                }
                st.push(new int[]{j, mn}); // 注意这里保存的不是 f[i][j]
            }
        }
        return f[d - 1][n - 1];
    }
}
/*
1335. 工作计划的最低难度
https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/description/

你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
提示：
1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10

单调栈优化 DP
https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/solutions/2271631/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-68nx/
时间复杂度 O(dn)。
相似题目: 2911. 得到 K 个半回文串的最少修改次数
https://leetcode.cn/problems/minimum-changes-to-make-k-semi-palindromes/description/
 */