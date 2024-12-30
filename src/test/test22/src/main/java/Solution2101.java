import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2101 {
    private int n;
    private Map<Integer, List<Integer>> adj;

    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r1 = bombs[i][2], r2 = bombs[j][2];
                long disPow = dx * dx + dy * dy;
                if (disPow <= r1 * r1) {
                    // bomb1 能引爆 bomb2
                    adj.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
                }
                if (disPow <= r2 * r2) {
                    // bomb2 能引爆 bomb1
                    adj.computeIfAbsent(j, key -> new ArrayList<>()).add(i);
                }
            }
        }

        int max = 0;
        for (int x = 0; x < n; x++) {
            max = Math.max(max, bfs(x));
        }
        return max;
    }

    // 引爆 x，能引爆的炸弹数目
    private int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(x);
        visited[x] = true;

        int res = 0;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            res++;

            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return res;
    }
}
/*
2101. 引爆最多的炸弹
https://leetcode.cn/problems/detonate-the-maximum-bombs/

第 67 场双周赛 T3。

给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，
ri 表示爆炸范围的 半径 。
你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
提示：
1 <= bombs.length <= 100
bombs[i].length == 3
1 <= xi, yi, ri <= 10^5

BFS
O(n^2) 建图，然后枚举每个起点，O(n^2) bfs 求引爆数量，求最大值。
（比赛时先入为主以为是无向图并查集，发现时为时已晚。。）
时间复杂度 O(n^3)
空间复杂度 O(n^2)
 */