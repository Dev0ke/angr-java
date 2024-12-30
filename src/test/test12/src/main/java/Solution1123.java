public class Solution1123 {
    private int[] depth;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth = new int[1001];
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
1123. 最深叶节点的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/

给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
回想一下：
- 叶节点 是二叉树中没有子节点的节点
- 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
- 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
提示：
树中的节点数将在 [1, 1000] 的范围内。
0 <= Node.val <= 1000
每个节点的值都是 独一无二 的。

两次 DFS，第一次计算深度，第二次找节点。
同: 865. 具有所有最深节点的最小子树
https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
 */