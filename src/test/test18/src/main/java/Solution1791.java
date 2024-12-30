public class Solution1791 {
    public int findCenter(int[][] edges) {
        int node0 = edges[0][0];
        int node1 = edges[0][1];
        int node2 = edges[1][0];
        int node3 = edges[1][1];
        if(node0 == node2 || node0 == node3){
            return node0;
        }
        return node1;
    }
}
/*
1791. 找出星型图的中心节点
https://leetcode.cn/problems/find-center-of-star-graph/

有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
提示：
3 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
题目数据给出的 edges 表示一个有效的星型图

因为题目保证用例是一个有效的星型图，因此中心节点必在 edges[0][0] 和  edges[0][1] 之间。
时间复杂度 O(1)
 */