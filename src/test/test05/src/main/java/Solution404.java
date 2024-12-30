public class Solution404 {
    private int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (isLeafNode(root.left)) {
                sum += root.left.val;
            } else {
                dfs(root.left);
            }
        }
        if (root.right != null && !isLeafNode(root.right)) {
            dfs(root.right);
        }
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
/*
404. 左叶子之和
https://leetcode.cn/problems/sum-of-left-leaves/

给定二叉树的根节点 root ，返回所有左叶子之和。
提示:
节点数在 [1, 1000] 范围内
-1000 <= Node.val <= 1000

DFS。
 */