public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        return traverse(root, root.val);
    }

    private boolean traverse(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val == value) {
            return traverse(root.left, value) && traverse(root.right, value);
        }
        return false;
    }
}
/*
965. 单值二叉树
https://leetcode.cn/problems/univalued-binary-tree/

第 117 场周赛 T1。

如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
只有给定的树是单值二叉树时，才返回 true；否则返回 false。
提示：
给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。

递归判断即可。
 */