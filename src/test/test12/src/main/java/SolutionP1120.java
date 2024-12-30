public class SolutionP1120 {
    private double max;

    public double maximumAverageSubtree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    // [总和, 个数]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 5e3 * 1e5
        int sum = node.val + left[0] + right[0];
        int cnt = 1 + left[1] + right[1];
        max = Math.max(max, (double) sum / cnt);
        return new int[]{sum, cnt};
    }
}
/*
$1120. 子树的最大平均值
https://leetcode.cn/problems/maximum-average-subtree/

给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
子树是树中的任意节点和它的所有后代构成的集合。
树的平均值是树中节点值的总和除以节点数。
提示：
树中的节点数介于 1 到 5000之间。
每个节点的值介于 0 到 100000 之间。
如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。

递归
 */