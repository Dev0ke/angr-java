public class SolutionP270 {
    private double min = Integer.MAX_VALUE;
    private int res;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode treeNode, double target) {
        if (treeNode == null) {
            return;
        }
        if (Math.abs(treeNode.val - target) < min) {
            min = Math.min(min, Math.abs(treeNode.val - target));
            res = treeNode.val;
        }
        dfs(treeNode.left, target);
        dfs(treeNode.right, target);
    }
}
/*
$270. 最接近的二叉搜索树值
https://leetcode.cn/problems/closest-binary-search-tree-value/

给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
注意：
- 给定的目标值 target 是一个浮点数
- 题目保证在该二叉搜索树中只会存在一个最接近目标值的数

dfs
 */