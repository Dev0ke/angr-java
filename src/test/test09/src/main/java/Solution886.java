import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 预处理
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];

            Set<Integer> outSet = graph.getOrDefault(from, new HashSet<>());
            outSet.add(to);
            graph.put(from, outSet);

            Set<Integer> inSet = graph.getOrDefault(to, new HashSet<>());
            inSet.add(from);
            graph.put(to, inSet);
        }

        int[] colors = new int[n + 1];
        // -1:未染色 0:红色 1:蓝色
        Arrays.fill(colors, -1);

        // 给定一组 n 人（编号为 1, 2, ..., n）
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setColor(Map<Integer, Set<Integer>> graph, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.remove();

            for (int next : graph.getOrDefault(cur, new HashSet<>())) {
                if (colors[next] != -1) {
                    if (colors[next] == colors[cur]) {
                        return false;
                    }
                } else {
                    colors[next] = 1 ^ colors[cur];
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
/*
886. 可能的二分法
https://leetcode.cn/problems/possible-bipartition/

给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
提示：
1 <= n <= 2000
0 <= dislikes.length <= 10^4
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
dislikes 中每一组都 不同

二部图判定。将 dislikes 关系看成二部图的两部分。
相似题目: 785. 判断二分图
https://leetcode.cn/problems/is-graph-bipartite/
 */