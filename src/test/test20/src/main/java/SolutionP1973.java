public class SolutionP1973 {
    private int ans;

    public int equalToDescendants(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode x) {
        if (x == null) return 0;
        int w = dfs(x.left) + dfs(x.right);
        ans += x.val == w ? 1 : 0;
        return x.val + w;
    }
}
/*
$1973. 值等于子节点值之和的节点数量
https://leetcode.cn/problems/count-nodes-equal-to-sum-of-descendants/description/

给定一颗二叉树的根节点 root ，返回满足条件：节点的值等于该节点所有子节点的值之和 的节点的数量。
一个节点 x 的 子节点 是指从节点 x 出发，到所有叶子节点路径上的节点。没有子节点的节点的子节点和视为 0 。
提示：
树中节点的数量范围： [1, 10^5]
0 <= Node.val <= 10^5

递归。
时间复杂度 O(n)。
 */