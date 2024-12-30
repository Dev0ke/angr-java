public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        // -2^31 <= Node.val <= 2^31 - 1
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}
/*
98. 验证二叉搜索树
https://leetcode.cn/problems/validate-binary-search-tree/

给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
- 节点的左子树只包含 小于 当前节点的数。
- 节点的右子树只包含 大于 当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。
提示：
树中节点数目范围在[1, 10^4] 内
-2^31 <= Node.val <= 2^31 - 1

前序遍历。注意需要开到 Long
相似题目: $333. 最大 BST 子树
https://leetcode.cn/problems/largest-bst-subtree/
1373. 二叉搜索子树的最大键值和
https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/
 */