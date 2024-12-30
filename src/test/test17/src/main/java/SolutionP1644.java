public class SolutionP1644 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // root 是否包含 p q
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean rootEqPq = root.val == p.val || root.val == q.val;

        if ((left && right) || rootEqPq && (left || right)) {
            ans = root;
        }
        return left || right || rootEqPq;
    }
}
/*
$1644. 二叉树的最近公共祖先 II
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-ii/

给定一棵二叉树的根节点 root，返回给定节点 p 和 q 的最近公共祖先（LCA）节点。如果 p 或 q 之一 不存在 于该二叉树中，返回 null。树中的每个节点值都是互不相同的。
根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是 后代节点 中既包括 p 又包括 q 的最深节点
（我们允许 一个节点为自身的一个后代节点 ）”。一个节点 x 的 后代节点 是节点 x 到某一叶节点间的路径中的节点 y。提示:
树中节点个数的范围是 [1, 10^4]
-10^9 <= Node.val <= 10^9
所有节点的值 Node.val 互不相同
p != q
进阶： 在不检查节点是否存在的情况下，你可以遍历树找出最近公共祖先节点吗？

与 236 题差异是节点可能不存在
相似题目: 236. 二叉树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */