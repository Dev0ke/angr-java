public class SolutionP776 {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val <= target) {
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0];
            res[0] = root;
            return res;
        } else {
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1];
            res[1] = root;
            return res;
        }
    }
}
/*
$776. 拆分二叉搜索树
https://leetcode.cn/problems/split-bst/

给你一棵二叉搜索树（BST）的根结点 root 和一个整数 target 。请将该树按要求拆分为两个子树：其中一个子树结点的值都必须小于等于给定的目标值；另一个子树结点的值都必须大于目标值；树中并非一定要存在值为 target 的结点。
除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 p 的任意子节点 c ，假如拆分后它们仍在同一个子树中，那么结点 p 应仍为 c 的父结点。
返回 两个子树的根结点的数组 。
提示：
二叉搜索树节点个数在 [1, 50] 范围内
0 <= Node.val, target <= 1000

递归
 */