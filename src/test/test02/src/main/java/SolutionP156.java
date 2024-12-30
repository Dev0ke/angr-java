public class SolutionP156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // root为空或是叶子节点返回
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // 只递归处理左子树，不需处理右子树，右子树都是叶子节点
        TreeNode newRoot = upsideDownBinaryTree(root.left);

        // 三角关系翻转
        root.left.left = root.right;
        root.left.right = root;

        // 根或子树的root变为右叶子节点
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
/*
$156. 上下翻转二叉树
https://leetcode.cn/problems/binary-tree-upside-down/

给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。
你可以按下面的步骤翻转一棵二叉树：
1.原来的左子节点变成新的根节点
2.原来的根节点变成新的右子节点
3.原来的右子节点变成新的左子节点
提示：
树中节点数目在范围 [0, 10] 内
1 <= Node.val <= 10
树中的每个右节点都有一个同级节点（即共享同一父节点的左节点）
树中的每个右节点都没有子节点

 x        x
/ \  =>  /
y  z    y - z

  1        1
 / \  =>  /
 2  3    2 - 3
/ \     /
4  5    4 - 5
 */