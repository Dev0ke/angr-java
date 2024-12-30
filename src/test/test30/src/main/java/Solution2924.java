import java.util.ArrayList;
import java.util.List;

public class Solution2924 {
    public int findChampion(int n, int[][] edges) {
        int[] inDeg = new int[n];
        for (int[] p : edges) {
            inDeg[p[1]]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans.size() == 1 ? ans.get(0) : -1;
    }
}
/*
2924. 找到冠军 II
https://leetcode.cn/problems/find-champion-ii/description/

第 370 场周赛 T2。

一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。每支队伍也是 有向无环图（DAG） 上的一个节点。
给你一个整数 n 和一个下标从 0 开始、长度为 m 的二维整数数组 edges 表示这个有向无环图，其中 edges[i] = [ui, vi] 表示图中存在一条从 ui 队到 vi 队的有向边。
从 a 队到 b 队的有向边意味着 a 队比 b 队 强 ，也就是 b 队比 a 队 弱 。
在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
如果这场比赛存在 唯一 一个冠军，则返回将会成为冠军的队伍。否则，返回 -1 。
注意
- 环 是形如 a1, a2, ..., an, an+1 的一个序列，且满足：节点 a1 与节点 an+1 是同一个节点；节点 a1, a2, ..., an 互不相同；对于范围 [1, n] 中的每个 i ，均存在一条从节点 ai 到节点 ai+1 的有向边。
- 有向无环图 是不存在任何环的有向图。
提示：
1 <= n <= 100
m == edges.length
0 <= m <= n * (n - 1) / 2
edges[i].length == 2
0 <= edge[i][j] <= n - 1
edges[i][0] != edges[i][1]
生成的输入满足：如果 a 队比 b 队强，就不存在 b 队比 a 队强
生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强

拓扑排序，入度为 0 的节点有且只有一个。
时间复杂度 O(n)
相似题目: 2923. 找到冠军 I
https://leetcode.cn/problems/find-champion-i/description/
 */