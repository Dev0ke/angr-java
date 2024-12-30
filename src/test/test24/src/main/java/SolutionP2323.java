import java.util.Arrays;

public class SolutionP2323 {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for (int i = 0; i < jobs.length; i++) {
            int x = jobs[i], y = workers[i];
            // 数论向上取整
            ans = Math.max(ans, (x + y - 1) / y);
        }
        return ans;
    }
}
/*
$2323. 完成所有工作的最短时间 II
https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs-ii/description/

给你两个 下标从 0 开始 的整数数组 jobs 和 相等 长度的 workers ，其中 jobs[i]是完成第 i 个工作所需的时间，workers[j] 是第 j 个工人每天可以工作的时间。
每项工作都应该 正好 分配给一个工人，这样每个工人就 只能 完成一项工作。
返回分配后完成所有作业所需的最少天数。
提示:
n == jobs.length == workers.length
1 <= n <= 10^5
1 <= jobs[i], workers[i] <= 10^5

贪心。
时间复杂度 O(nlogn)。
 */