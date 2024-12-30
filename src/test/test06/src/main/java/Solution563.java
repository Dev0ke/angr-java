public class Solution563 {
    private int ans;

    public int findTilt(TreeNode root) {
        postorder(root);
        return ans;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postorder(root.left);
        int right = postorder(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
/*
563. 二叉树的坡度
https://leetcode.cn/problems/binary-tree-tilt/

给定一个二叉树，计算 整个树 的坡度 。
一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
整个树 的坡度就是其所有节点的坡度之和。
提示：
树中节点数目的范围在 [0, 10^4] 内
-1000 <= Node.val <= 1000

后序遍历
 */