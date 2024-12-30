import java.util.ArrayList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(0, graph, new ArrayList<>(), resList);
        return resList;
    }

    private void dfs(int source, int[][] graph, List<Integer> path, List<List<Integer>> resList) {
        path.add(source);
        if (source == graph.length - 1) {
            resList.add(new ArrayList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, resList);
            }
        }
        path.remove(path.size() - 1);
    }
}
/*
797. 所有可能的路径
https://leetcode.cn/problems/all-paths-from-source-to-target/

给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
提示：
n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i（即不存在自环）
graph[i] 中的所有元素 互不相同
保证输入为 有向无环图（DAG）

深度优先搜索。
 */