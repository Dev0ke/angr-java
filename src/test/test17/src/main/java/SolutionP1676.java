public class SolutionP1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return null;
        }
        for (TreeNode node : nodes) {
            if (node == root) {
                return root;
            }
        }
        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        // 若左右子树均存在nodes中的节点，则最近公共祖先就是root
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
/*
$1676. 二叉树的最近公共祖先 IV
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv/

给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，返回 nodes 中所有节点的最近公共祖先（LCA）。
数组（列表）中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。
我们扩展二叉树的最近公共祖先节点在维基百科上的定义：
“对于任意合理的 i 值， n 个节点 p1 、 p2、...、 pn 在二叉树 T 中的最近公共祖先节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。
一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
提示:
树中节点个数的范围是 [1, 10^4] 。
-10^9 <= Node.val <= 10^9
所有的 Node.val 都是互不相同的。
所有的 nodes[i] 都存在于该树中。
所有的 nodes[i] 都是互不相同的。

递归
 */