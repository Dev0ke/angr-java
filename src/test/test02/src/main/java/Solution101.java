public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
/*
101. 对称二叉树
https://leetcode.cn/problems/symmetric-tree/

给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
提示：
树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100
进阶：你可以运用递归和迭代两种方法解决这个问题吗？

同: 剑指 Offer 28. 对称的二叉树
https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 */