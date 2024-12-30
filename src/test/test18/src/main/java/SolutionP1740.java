public class SolutionP1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int l = dfs(lca, p);
        int r = dfs(lca, q);
        return l + r;
    }

    // 根节点 到 x 的距离
    private int dfs(TreeNode root, int x) {
        if (root == null) return -1;
        if (root.val == x) return 0;
        int l = dfs(root.left, x);
        if (l != -1) return l + 1;
        int r = dfs(root.right, x);
        if (r != -1) return r + 1;
        return -1;
    }

    // 236
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
/*
$1740. 找到二叉树中的距离
https://leetcode.cn/problems/find-distance-in-a-binary-tree/description/

给定一棵二叉树的根节点 root 以及两个整数 p 和 q ，返回该二叉树中值为 p 的结点与值为 q 的结点间的 距离 。
两个结点间的 距离 就是从一个结点到另一个结点的路径上边的数目。
提示：
树中结点个数的范围在 [1, 10^4].
0 <= Node.val <= 10^9
树中所有结点的值都是唯一的.
p 和q 是树中结点的值.

LCA。
相似题目: 236. 二叉树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */