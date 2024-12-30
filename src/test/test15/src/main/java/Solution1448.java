public class Solution1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int pathMax) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val >= pathMax) {
            res++;
            pathMax = node.val;
        }
        res += dfs(node.left, pathMax) + dfs(node.right, pathMax);
        return res;
    }
}
/*
1448. 统计二叉树中好节点的数目
https://leetcode.cn/problems/count-good-nodes-in-binary-tree/

给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
提示：
二叉树中节点数目范围是 [1, 10^5] 。
每个节点权值的范围是 [-10^4, 10^4] 。

递归
时间复杂度 O(n)
 */