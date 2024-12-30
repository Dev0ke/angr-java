public class Solution99 {
    public void recoverTree(TreeNode root) {
        // Mirrors 中序遍历
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        TreeNode predecessor;

        while (root != null) {
            // 先访问左子树
            if (root.left != null) {
                // predecessor 节点为 root 节点向左一步，再向右走到尽头
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // predecessor 指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 左子树已访问完
                else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左子树，直接访问右子树
            else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
/*
99. 恢复二叉搜索树
https://leetcode.cn/problems/recover-binary-search-tree/

给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
提示：
树上节点的数目在范围 [2, 1000] 内
-2^31 <= Node.val <= 2^31 - 1
进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？

Mirrors 中序遍历
时间复杂度 O(n)
空间复杂度 O(1)
 */