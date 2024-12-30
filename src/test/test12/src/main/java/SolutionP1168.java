import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // 只修建管道是没有水的，所以必须在至少一个房子内直接建水井
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            edges.add(List.of(0, i, wells[i - 1]));
        }
        for (int[] pipe : pipes) {
            edges.add(List.of(pipe[0], pipe[1], pipe[2]));
        }

        // Kruskal 算法
        edges.sort(Comparator.comparingInt(o -> o.get(2)));
        DSU dsu = new DSU(n + 1);
        int cost = 0;
        for (List<Integer> edge : edges) {
            if (dsu.find(edge.get(0)) != dsu.find(edge.get(1))) {
                dsu.union(edge.get(0), edge.get(1));
                cost += edge.get(2);
            }
        }
        if (dsu.sz == 1) {
            return cost;
        }
        return -1;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
$1168. 水资源分配优化
https://leetcode.cn/problems/optimize-water-distribution-in-a-village/

村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
对于每个房子 i，我们有两种可选的供水方案：一种是直接在房子内建造水井，成本为 wells[i - 1] （注意 -1 ，因为 索引从0开始 ）；
另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[j] = [house1j, house2j, costj]
代表用管道将 house1j 和 house2j连接在一起的成本。连接是双向的。
请返回 为所有房子都供水的最低总成本 。
提示：
2 <= n <= 10^4
wells.length == n
0 <= wells[i] <= 10^5
1 <= pipes.length <= 10^4
pipes[j].length == 3
1 <= house1j, house2j <= n
0 <= costj <= 10^5
house1j != house2j

最小生成树(MST)
Kruskal 算法
只修建管道是没有水的，所以必须在至少一个房子内直接建水井，本题难点在于对水井的处理，将水井看成是节点 0 到房子 i 的一条有权边。
故问题转化为 求节点 0 到节点 n 的最小生成树。
 */