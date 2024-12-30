import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(id -> tasks[id][0]));

        // processingTime, idx
        // CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.processingTime == o2.processingTime) {
                return Integer.compare(o1.index, o2.index);
            }
            return Integer.compare(o1.processingTime, o2.processingTime);
        });

        int j = 0; // id = ids[j];
        int ts = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (taskQueue.isEmpty()) {
                ts = Math.max(ts, tasks[ids[j]][0]);
            }

            while (j < n && tasks[ids[j]][0] <= ts) {
                taskQueue.add(new Task(tasks[ids[j]][1], ids[j]));
                j++;
            }

            Task top = taskQueue.remove();
            ts += top.processingTime;
            ans[i] = top.index;
        }
        return ans;
    }

    static class Task {
        int processingTime, index;

        public Task(int processingTime, int index) {
            this.processingTime = processingTime;
            this.index = index;
        }
    }
}
/*
1834. 单线程 CPU
https://leetcode.cn/problems/single-threaded-cpu/description/

给你一个二维数组 tasks ，用于表示 n 项从 0 到 n - 1 编号的任务。其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
- 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
- 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
- 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
- CPU 可以在完成一项任务后，立即开始执行一项新任务。
返回 CPU 处理任务的顺序。
提示：
tasks.length == n
1 <= n <= 10^5
1 <= enqueueTimei, processingTimei <= 10^9

排序 + 优先队列。
时间复杂度 O(nlogn)。
相似题目: 1882. 使用服务器处理任务
https://leetcode.cn/problems/process-tasks-using-servers/description/
 */