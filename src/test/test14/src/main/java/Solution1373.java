public class Solution1373 {
    private int max;

    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            sum(root);
            return max;
        }
        return Math.max(maxSumBST(root.left), maxSumBST(root.right));
    }

    // solution98
    private boolean validBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = sum(root.left) + sum(root.right) + root.val;
        max = Math.max(max, res);
        return res;
    }
}
/*
1373. 二叉搜索子树的最大键值和
https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/

给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
二叉搜索树的定义如下：
- 任意节点的左子树中的键值都 小于 此节点的键值。
- 任意节点的右子树中的键值都 大于 此节点的键值。
- 任意节点的左子树和右子树都是二叉搜索树。
提示：
每棵树有 1 到 40000 个节点。
每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。

相似题目: 98. 验证二叉搜索树
https://leetcode.cn/problems/validate-binary-search-tree/
$333. 最大 BST 子树
https://leetcode.cn/problems/largest-bst-subtree/
 */