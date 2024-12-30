import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 拓扑排序
        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, List<Integer>> rg = new HashMap<>();
        // 二维整数数组 relations ，其中 relations[j] = [prevCoursej, nextCoursej] ，
        // 表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。
        int[] inDeg = new int[n + 1];
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            inDeg[next]++;
            g.computeIfAbsent(prev, key -> new ArrayList<>()).add(next);
            rg.computeIfAbsent(next, key -> new ArrayList<>()).add(prev);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        // 有 n 节课，课程编号从 1 到 n
        for (int x = 1; x <= n; x++) {
            if (inDeg[x] == 0) {
                queue.add(x);
            }
        }
        // dp[i] 表示完成第 i 门课程需要花费的最少月份数
        int[] dp = new int[n + 1];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                // dp[i] = time[i-1] + max(dp[pre])
                int maxPre = 0;
                for (int pre : rg.getOrDefault(x, new ArrayList<>())) {
                    maxPre = Math.max(maxPre, dp[pre]);
                }
                dp[x] = time[x - 1] + maxPre;

                for (int next : g.getOrDefault(x, new ArrayList<>())) {
                    inDeg[next]--;
                    if (inDeg[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        // 最少 月份数 max(dp[i])
        return Arrays.stream(dp).max().orElseThrow();
    }
}
/*
2050. 并行课程 III
https://leetcode.cn/problems/parallel-courses-iii/

第 264 场周赛 T4。

给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。同时给你一个二维整数数组 relations ，
其中 relations[j] = [prevCoursej, nextCoursej] ，表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。
同时给你一个下标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。
请你根据以下规则算出完成所有课程所需要的 最少 月份数：
如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。
你可以 同时 上 任意门课程 。
请你返回完成所有课程所需要的 最少 月份数。
注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。

拓扑排序 + 动态规划。
值得一提的是，直接拓扑排序求各层最大值是不正确的，因为可以在 任意 时间开始这门课程。如 用例:
9
[[2,7],[2,6],[3,6],[4,6],[7,6],[2,1],[3,1],[4,1],[6,1],[7,1],[3,8],[5,8],[7,8],[1,9],[2,9],[6,9],[7,9]]
[9,5,9,5,8,7,7,8,4]
32
相似题目: 851. 喧闹和富有
https://leetcode.cn/problems/loud-and-rich/
 */