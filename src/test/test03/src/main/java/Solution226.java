public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历 swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
/*
226. 翻转二叉树
https://leetcode.cn/problems/invert-binary-tree/

给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
提示：
树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100
     4                4
   /   \            /   \
  2     7    =>    7     2
 / \   / \        / \   / \
1   3 6   9      9   6 3   1

前序（或后序）遍历交换左右叶子节点即可
 */