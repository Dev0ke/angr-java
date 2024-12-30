public class SolutionP333 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return cnt(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
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

    private int cnt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return cnt(root.left) + cnt(root.right) + 1;
    }
}
/*
$333. 最大 BST 子树
https://leetcode.cn/problems/largest-bst-subtree/

给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
二叉搜索树（BST）中的所有节点都具备以下属性：
- 左子树的值小于其父（根）节点的值。
- 右子树的值大于其父（根）节点的值。
注意：子树必须包含其所有后代。
提示：
树上节点数目的范围是 [0, 10^4]
-10^4 <= Node.val <= 10^4

相似题目: 98. 验证二叉搜索树
https://leetcode.cn/problems/validate-binary-search-tree/
1373. 二叉搜索子树的最大键值和
https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/
 */