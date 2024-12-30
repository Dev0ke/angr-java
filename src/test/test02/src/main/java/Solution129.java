public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }

    private int preorder(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return preorder(root.left, path) + preorder(root.right, path);
    }
}
/*
129. 求根节点到叶节点数字之和
https://leetcode.cn/problems/sum-root-to-leaf-numbers/

给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：
- 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。
叶节点 是指没有子节点的节点。
提示：
树中节点的数目在范围 [1, 1000] 内
0 <= Node.val <= 9
树的深度不超过 10

  1
 / \
2   3
12 + 13 = 25
前序遍历
 */