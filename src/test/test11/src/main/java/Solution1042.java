import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1042 {
    private Map<Integer, List<Integer>> adj;
    private int[] res;

    public int[] gardenNoAdj(int n, int[][] paths) {
        adj = new HashMap<>();
        for (int[] path : paths) {
            int u = path[0] - 1, v = path[1] - 1;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        res = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs(int x) {
        // 0b11110
        int mask = (1 << 5) - 2;
//        TreeSet<Integer> set = new TreeSet<>(List.of(1, 2, 3, 4));
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
//            set.remove(res[y]);
            // 将一个数二进制的某一位置 0
            mask &= ~(1 << res[y]);
        }
//        res[x] = set.first();
        res[x] = Integer.numberOfTrailingZeros(Integer.lowestOneBit(mask));
    }
}
/*
1042. 不邻接植花
https://leetcode.cn/problems/flower-planting-with-no-adjacent/

有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
另外，所有花园 最多 有 3 条路径可以进入或离开.
你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
提示：
1 <= n <= 10^4
0 <= paths.length <= 2 * 10^4
paths[i].length == 2
1 <= xi, yi <= n
xi != yi
每个花园 最多 有 3 条路径可以进入或离开

可以用大小为 4 的集合，也可以用 位运算。
时间复杂度 O(n+m)
空间复杂度 O(n+m)
 */