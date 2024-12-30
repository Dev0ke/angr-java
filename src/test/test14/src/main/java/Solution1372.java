public class Solution1372 {
    private int max;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return max;
    }

    // right:true 向右
    private void dfs(TreeNode node, boolean right, int len) {
        max = Math.max(max, len);
        // 向左
        if (!right) {
            if (node.left != null) {
                dfs(node.left, true, len + 1);
            }
            if (node.right != null) {
                dfs(node.right, false, 1);
            }
        }
        // 向右
        else {
            if (node.left != null) {
                dfs(node.left, true, 1);
            }
            if (node.right != null) {
                dfs(node.right, false, len + 1);
            }
        }
    }
}
/*
1372. 二叉树中的最长交错路径
https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/

给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
- 选择二叉树中 任意 节点和一个方向（左或者右）。
- 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
- 改变前进方向：左变右或者右变左。
- 重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
请你返回给定树中最长 交错路径 的长度。
提示：
每棵树最多有 50000 个节点。
每个节点的值在 [1, 100] 之间。

DFS
时间复杂度 O(n)
空间复杂度 O(1)
 */