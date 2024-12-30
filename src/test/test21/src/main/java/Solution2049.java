import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2049 {
    private int n;
    private Map<Integer, List<Integer>> adj;
    private long maxScore;
    private int res = 0;

    public int countHighestScoreNodes(int[] parents) {
        // 建图
        n = parents.length;
        adj = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int u = parents[i];
            int v = i;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
        }

        maxScore = 0;
        res = 0;
        dfs(0);
        return res;
    }

    // 以 node 为跟的子树大小
    private int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for (int child : adj.getOrDefault(node, new ArrayList<>())) {
            int sz = dfs(child);
            score *= sz;
            size -= sz;
        }
        // 移除根节点 0 时，最多只会有两棵子树
        if (node != 0) {
            score *= size;
        }
        if (score > maxScore) {
            maxScore = score;
            res = 1;
        } else if (score == maxScore) {
            res++;
        }
        return n - size;
    }
}
/*
2049. 统计最高分的节点数目
https://leetcode.cn/problems/count-nodes-with-the-highest-score/

第 264 场周赛 T3。

给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，
其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，
剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
请你返回有 最高得分 节点的 数目 。
提示：
n == parents.length
2 <= n <= 10^5
parents[0] == -1
对于 i != 0 ，有 0 <= parents[i] <= n - 1
parents 表示一棵二叉树。

除根节点外，移除一个节点最多可以把树分成三部分：左子树、右子树，整棵树移除当前节点子树后形成的子树。建图后跑 DFS 即可。
时间复杂度 O(n)
空间复杂度 O(n)
 */
