public class Solution865 {
    private int[] depth;
    private int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new int[501];
        dfs(root, 0);
        return dfs2(root);
    }

    private void dfs(TreeNode node, int d) {
        if (node == null) {
            return;
        }
        depth[node.val] = d + 1;
        maxDepth = Math.max(maxDepth, depth[node.val]);
        dfs(node.left, d + 1);
        dfs(node.right, d + 1);
    }

    private TreeNode dfs2(TreeNode node) {
        if (node == null || depth[node.val] == maxDepth) {
            return node;
        }
        TreeNode left = dfs2(node.left);
        TreeNode right = dfs2(node.right);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
/*
865. 具有所有最深节点的最小子树
https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/

给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
返回包含原始树中所有 最深节点 的 最小子树 。
如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
一个节点的 子树 是该节点加上它的所有后代的集合。
提示：
树中节点的数量在 [1, 500] 范围内。
0 <= Node.val <= 500
每个节点的值都是 独一无二 的。

两次 DFS，第一次计算深度，第二次找节点。
同: 1123. 最深叶节点的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/
 */