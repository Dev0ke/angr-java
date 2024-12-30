import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution332 {
    // 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
    private Map<String, PriorityQueue<String>> adj;
    private List<String> resList;

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            adj.computeIfAbsent(u, key -> new PriorityQueue<>()).add(v);
        }
        resList = new ArrayList<>();

        // 欧拉通路 / 欧拉回路
        // 该行程必须从 JFK 开始
        dfs("JFK");
        Collections.reverse(resList);
        return resList;
    }

    private void dfs(String u) {
        // 当我们遍历完一个节点所连的所有节点后，我们才将该节点入队（即逆序入队）
        while (adj.containsKey(u) && adj.get(u).size() > 0) {
            String v = adj.get(u).poll();
            dfs(v);
        }
        resList.add(u);
    }
}
/*
332. 重新安排行程
https://leetcode.cn/problems/reconstruct-itinerary/

给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
- 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
提示：
1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi 和 toi 由大写英文字母组成
fromi != toi

Hierholzer 算法。
关于欧拉路:
- 通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路。
- 通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路。
- 具有欧拉回路的无向图称为欧拉图。
- 具有欧拉通路但不具有欧拉回路的无向图称为半欧拉图。
根据题意，这个是一个欧拉路（通路或回路）。
对于有向图：
对于有向图 G，G 是欧拉图当且仅当 G 的所有顶点属于同一个强连通分量且每个顶点的入度和出度相同。
对于有向图 G，G 是半欧拉图当且仅当 G 的所有顶点属于同一个强连通分量且
恰有一个顶点的出度与入度差为 1；
恰有一个顶点的入度与出度差为 1；
所有其他顶点的入度和出度相同。
时间复杂度 O(mlogm) m 为边的数量
空间复杂度 O(m) 需要存储每一条边
相似题目: 2097. 合法重新排列数对
https://leetcode.cn/problems/valid-arrangement-of-pairs/
 */