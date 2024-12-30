import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] g = new HashSet[n];
        Arrays.setAll(g, e -> new HashSet<>());
        for (int[] p : roads) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (g[i].contains(j)) {
                    ans = Math.max(ans, g[i].size() + g[j].size() - 1);
                } else {
                    ans = Math.max(ans, g[i].size() + g[j].size());
                }
            }
        }
        return ans;
    }
}
/*
1615. 最大网络秩
https://leetcode.cn/problems/maximal-network-rank/

n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
提示：
2 <= n <= 100
0 <= roads.length <= n * (n - 1) / 2
roads[i].length == 2
0 <= ai, bi <= n-1
ai != bi
每对城市之间 最多只有一条 道路相连

建图后枚举。
时间复杂度 O(n^2)
 */