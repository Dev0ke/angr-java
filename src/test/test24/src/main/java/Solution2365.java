import java.util.HashMap;
import java.util.Map;

public class Solution2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        // 任务完成时间
        Map<Integer, Long> preMap = new HashMap<>();
        long ans = 0L;
        for (int task : tasks) {
            ans++;
            if (!preMap.containsKey(task)) {
                preMap.put(task, ans);
            } else {
                long pre = preMap.get(task);
                if (ans - pre <= space) {
                    ans = space + pre + 1;
                    preMap.put(task, ans);
                } else {
                    preMap.put(task, ans);
                }
            }
        }
        return ans;
    }
}
/*
2365. 任务调度器 II
https://leetcode.cn/problems/task-scheduler-ii/

第 84 场双周赛 T3。

给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。
同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。
在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：
- 完成 tasks 中的下一个任务
- 休息一天
请你返回完成所有任务所需的 最少 天数。
提示：
1 <= tasks.length <= 10^5
1 <= tasks[i] <= 10^9
1 <= space <= tasks.length

贪心。task 能做就做，除非被迫休息。
时间复杂度：O(n)
相似题目: 621. 任务调度器
https://leetcode.cn/problems/task-scheduler/
 */