import java.util.HashMap;
import java.util.Map;

public class Solution2458 {
    private Map<TreeNode, Integer> nodeHMap;
    private int[] rmNodeH;

    public int[] treeQueries(TreeNode root, int[] queries) {
        nodeHMap = new HashMap<>();
        nodeHMap.put(null, 0);
        dfs(root);

        int q = queries.length;
        rmNodeH = new int[nodeHMap.size()];
        dfs2(root, -1, 0);

        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            res[i] = rmNodeH[queries[i]];
        }
        return res;
    }

    // 每棵子树的高度
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int h = Math.max(dfs(node.left), dfs(node.right)) + 1;
        nodeHMap.put(node, h);
        return h;
    }

    private void dfs2(TreeNode node, int depth, int resH) {
        if (node == null) {
            return;
        }
        depth++;
        rmNodeH[node.val] = resH;
        dfs2(node.left, depth, Math.max(resH, depth + nodeHMap.get(node.right)));
        dfs2(node.right, depth, Math.max(resH, depth + nodeHMap.get(node.left)));
    }
}
/*
2458. 移除子树后的二叉树高度
https://leetcode.cn/problems/height-of-binary-tree-after-subtree-removal-queries/

第 317 场周赛 T4。

给你一棵 二叉树 的根节点 root ，树中有 n 个节点。每个节点都可以被分配一个从 1 到 n 且互不相同的值。另给你一个长度为 m 的数组 queries 。
你必须在树上执行 m 个 独立 的查询，其中第 i 个查询你需要执行以下操作：
- 从树中 移除 以 queries[i] 的值作为根节点的子树。题目所用测试用例保证 queries[i] 不 等于根节点的值。
返回一个长度为 m 的数组 answer ，其中 answer[i] 是执行第 i 个查询后树的高度。
注意：
- 查询之间是独立的，所以在每个查询执行后，树会回到其 初始 状态。
- 树的高度是从根到树中某个节点的 最长简单路径中的边数 。
提示：
树中节点的数目是 n
2 <= n <= 10^5
1 <= Node.val <= n
树中的所有值 互不相同
m == queries.length
1 <= m <= min(n, 10^4)
1 <= queries[i] <= n
queries[i] != root.val

两遍 DFS。
第一遍求每个子树的高度。
第二遍求删除当前子树后剩余部分的树的高度。
 */