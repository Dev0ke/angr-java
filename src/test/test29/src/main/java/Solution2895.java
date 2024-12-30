import java.util.Comparator;
import java.util.List;

public class Solution2895 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(null);
        tasks.sort(Comparator.reverseOrder());
        int ans = 0;
        int n = processorTime.size();
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, processorTime.get(i) + tasks.get(i * 4));
        }
        return ans;
    }
}
/*
2895. 最小处理时间
https://leetcode.cn/problems/minimum-processing-time/description/

第 366 场周赛 T2。

你有 n 颗处理器，每颗处理器都有 4 个核心。现有 n * 4 个待执行任务，每个核心只执行 一个 任务。
给你一个下标从 0 开始的整数数组 processorTime ，表示每颗处理器最早空闲时间。另给你一个下标从 0 开始的整数数组 tasks ，表示执行每个任务所需的时间。返回所有任务都执行完毕需要的 最小时间 。
注意：每个核心独立执行任务。
提示：
1 <= n == processorTime.length <= 25000
1 <= tasks.length <= 10^5
0 <= processorTime[i] <= 10^9
1 <= tasks[i] <= 10^9
tasks.length == 4 * n

贪心。最大和最小的配对，找最大值。
时间复杂度 O(nlogn)
 */