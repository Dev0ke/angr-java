public class Solution2492 {
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n + 1);
        for (int[] road : roads) {
            dsu.union(road[0], road[1]);
        }

        int min = Integer.MAX_VALUE;
        int fa = dsu.find(1);
        for (int[] road : roads) {
            if (dsu.find(road[0]) == fa || dsu.find(road[1]) == fa) {
                min = Math.min(min, road[2]);
            }
        }
        return min;
    }

    public static class DSU {
        // 父节点数组/祖先数组
        int[] fa;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
2492. 两个城市间路径的最小分数
https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/

第 322 场周赛 T3。

给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，
其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。
两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。
城市 1 和城市 n 之间的所有路径的 最小 分数。
注意：
- 一条路径指的是两个城市之间的道路序列。
- 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
- 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
提示：
2 <= n <= 10^5
1 <= roads.length <= 10^5
roads[i].length == 3
1 <= ai, bi <= n
ai != bi
1 <= distancei <= 10^4
不会有重复的边。
城市 1 和城市 n 之间至少有一条路径。

并查集。
枚举 当前连通分量 的所有边，找最小值。
 */