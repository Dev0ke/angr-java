import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3311 {
    public int[][] constructGridLayout(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        // 每种度数选一个点
        int[] degToNode = new int[5];
        Arrays.fill(degToNode, -1);
        for (int x = 0; x < n; x++) {
            degToNode[g[x].size()] = x;
        }

        List<Integer> row = new ArrayList<>();
        if (degToNode[1] != -1) {
            // 答案只有一列
            row.add(degToNode[1]);
        } else if (degToNode[4] == -1) {
            // 答案只有两列
            int x = degToNode[2];
            for (int y : g[x]) {
                if (g[y].size() == 2) {
                    row.add(x);
                    row.add(y);
                    break;
                }
            }
        } else {
            // 答案至少有三列
            // 寻找度数为 2333...32 的序列作为第一排
            int x = degToNode[2];
            row.add(x);
            int pre = x;
            x = g[x].get(0);
            while (g[x].size() == 3) {
                row.add(x);
                for (int y : g[x]) {
                    if (y != pre && g[y].size() < 4) {
                        pre = x;
                        x = y;
                        break;
                    }
                }
            }
            row.add(x); // x 的度数是 2
        }

        int k = row.size();
        int[][] ans = new int[n / k][k];
        boolean[] vis = new boolean[n];
        for (int j = 0; j < k; j++) {
            int x = row.get(j);
            ans[0][j] = x;
            vis[x] = true;
        }
        for (int i = 1; i < ans.length; i++) {
            for (int j = 0; j < k; j++) {
                for (int y : g[ans[i - 1][j]]) {
                    // 上左右的邻居都访问过了，没访问过的邻居只会在下面
                    if (!vis[y]) {
                        vis[y] = true;
                        ans[i][j] = y;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
/*
3311. 构造符合图结构的二维矩阵
https://leetcode.cn/problems/construct-2d-grid-matching-graph-layout/description/

第 418 场周赛 T3。

给你一个二维整数数组 edges ，它表示一棵 n 个节点的 无向 图，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间有一条边。
请你构造一个二维矩阵，满足以下条件：
- 矩阵中每个格子 一一对应 图中 0 到 n - 1 的所有节点。
- 矩阵中两个格子相邻（横 的或者 竖 的）当且仅当 它们对应的节点在 edges 中有边连接。
题目保证 edges 可以构造一个满足上述条件的二维矩阵。
请你返回一个符合上述要求的二维整数数组，如果存在多种答案，返回任意一个。
提示：
2 <= n <= 5 * 10^4
1 <= edges.length <= 10^5
edges[i] = [ui, vi]
0 <= ui < vi < n
图中的边互不相同。
输入保证 edges 可以形成一个符合上述条件的二维矩阵。

构造题。分类讨论。
先找角，再找边。先把第一排拼好，然后再考虑和第一排相关的拼图，依此类推。
rating 2645 (clist.by)
 */