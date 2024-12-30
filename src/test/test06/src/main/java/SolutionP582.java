import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionP582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // 拓扑排序
        int n = pid.size();
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int from = ppid.get(i);
            int to = pid.get(i);

            Set<Integer> outSet = outGraph.getOrDefault(from, new HashSet<>());
            outSet.add(to);
            outGraph.put(from, outSet);
        }
        List<Integer> resList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            resList.add(cur);
            // 每一个进程只有 一个父进程
            queue.addAll(outGraph.getOrDefault(cur, new HashSet<>()));
        }
        return resList;
    }
}
/*
$582. 杀掉进程
https://leetcode.cn/problems/kill-process/

系统中存在 n 个进程，形成一个有根树结构。给你两个整数数组 pid 和 ppid ，其中 pid[i] 是第 i 个进程的 ID ，ppid[i] 是第 i 个进程的父进程 ID 。
每一个进程只有 一个父进程 ，但是可能会有 一个或者多个子进程 。只有一个进程的 ppid[i] = 0 ，意味着这个进程 没有父进程 。
当一个进程 被杀掉 的时候，它所有的子进程和后代进程都要被杀掉。
给你一个整数 kill 表示要杀掉进程的 ID ，返回杀掉该进程后的所有进程 ID 的列表。可以按 任意顺序 返回答案。
提示：
n == pid.length
n == ppid.length
1 <= n <= 5 * 10^4
1 <= pid[i] <= 5 * 10^4
0 <= ppid[i] <= 5 * 10^4
仅有一个进程没有父进程
pid 中的所有值 互不相同
题目数据保证 kill 在 pid 中

拓扑排序
 */