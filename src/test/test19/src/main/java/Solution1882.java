import java.util.PriorityQueue;

public class Solution1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;

        // 权重, 下标
        // 你需要为它分配一台 权重最小 的空闲服务器。如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。
        PriorityQueue<Idle> idle = new PriorityQueue<>((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return Integer.compare(o1.index, o2.index);
            }
            return Integer.compare(o1.weight, o2.weight);
        });
        for (int i = 0; i < n; i++) {
            idle.add(new Idle(servers[i], i));
        }

        // 结束工作的时间, 下标
        PriorityQueue<Busy> busy = new PriorityQueue<>((o1, o2) -> {
            if (o1.finishTime == o2.finishTime) {
                return Long.compare(o1.index, o2.index);
            }
            return Long.compare(o1.finishTime, o2.finishTime);
        });

        long ts = 0;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ts = Math.max(ts, i);

            while (!busy.isEmpty() && busy.peek().finishTime <= ts) {
                Busy top = busy.remove();
                int idx = top.index;
                idle.add(new Idle(servers[idx], idx));
            }

            if (idle.isEmpty()) {
                ts = busy.peek().finishTime; // 这句不能放到循环里面 ts = top.finishTime;
                while (!busy.isEmpty() && busy.peek().finishTime <= ts) {
                    Busy top = busy.remove();
                    int idx = top.index;
                    idle.add(new Idle(servers[idx], idx));
                }
            }

            Idle top = idle.remove();
            int idx = top.index;
            busy.add(new Busy(ts + tasks[i], idx));
            ans[i] = idx;
        }
        return ans;
    }

    static class Idle {
        int weight, index;

        public Idle(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    static class Busy {
        long finishTime;
        int index;

        public Busy(long finishTime, int index) {
            this.finishTime = finishTime;
            this.index = index;
        }
    }
}
/*
1882. 使用服务器处理任务
https://leetcode.cn/problems/process-tasks-using-servers/description/

给你两个 下标从 0 开始 的整数数组 servers 和 tasks ，长度分别为 n 和 m。servers[i] 是第 i 台服务器的 权重 ，而 tasks[j] 是处理第 j 项任务 所需要的时间（单位：秒）。
你正在运行一个仿真系统，在处理完所有任务后，该系统将会关闭。每台服务器只能同时处理一项任务。第 0 项任务在第 0 秒可以开始处理，相应地，第 j 项任务在第 j 秒可以开始处理。
处理第 j 项任务时，你需要为它分配一台 权重最小 的空闲服务器。如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。如果一台空闲服务器在第 t 秒分配到第 j 项任务，那么在 t + tasks[j] 时它将恢复空闲状态。
如果没有空闲服务器，则必须等待，直到出现一台空闲服务器，并 尽可能早 地处理剩余任务。 如果有多项任务等待分配，则按照 下标递增 的顺序完成分配。
如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。
构建长度为 m 的答案数组 ans ，其中 ans[j] 是第 j 项任务分配的服务器的下标。
返回答案数组 ans 。
提示：
servers.length == n
tasks.length == m
1 <= n, m <= 2 * 10^5
1 <= servers[i], tasks[j] <= 2 * 10^5

优先队列。
时间复杂度 O((m+n)logm)。
相似题目: 1834. 单线程 CPU
https://leetcode.cn/problems/single-threaded-cpu/description/
 */