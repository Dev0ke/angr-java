import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution399 {
    private Map<String, Map<String, Double>> adj;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();

        // 建图
        adj = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String ai = equations.get(i).get(0);
            String bi = equations.get(i).get(1);
            adj.computeIfAbsent(ai, key -> new HashMap<>()).put(bi, values[i]);
            adj.computeIfAbsent(bi, key -> new HashMap<>()).put(ai, 1.0 / values[i]);
        }

        int q = queries.size();
        double[] res = new double[q];
        for (int i = 0; i < q; i++) {
            String ci = queries.get(i).get(0);
            String di = queries.get(i).get(1);
            if (!adj.containsKey(ci) || !adj.containsKey(di)) {
                res[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(ci, di, visited);
            }
        }
        return res;
    }

    private double dfs(String ci, String di, Set<String> visited) {
        if (ci.equals(di)) {
            return 1.0;
        }
        visited.add(ci);
        for (Map.Entry<String, Double> entry : adj.get(ci).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(next, di, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(ci);
        return -1.0;
    }
}
/*
399. 除法求值
https://leetcode.cn/problems/evaluate-division/

给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
提示：
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj 由小写英文字母与数字组成

深度优先搜索。
 */