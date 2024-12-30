public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
/*
700. 二叉搜索树中的搜索
https://leetcode.cn/problems/search-in-a-binary-search-tree/

给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
提示：
数中节点数在 [1, 5000] 范围内
1 <= Node.val <= 10^7
root 是二叉搜索树
1 <= val <= 10^7

递归
 */