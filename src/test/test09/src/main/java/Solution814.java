public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
/*
814. 二叉树剪枝
https://leetcode.cn/problems/binary-tree-pruning/

给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
返回移除了所有不包含 1 的子树的原二叉树。
节点 node 的子树为 node 本身加上所有 node 的后代。
提示：
树中节点的数目在范围 [1, 200] 内
Node.val 为 0 或 1

后序遍历
 */
