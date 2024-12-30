public class Solution993 {
    private int x, y, depth;
    private TreeNode father;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        return dfs(root, null, 1);
    }

    private boolean dfs(TreeNode node, TreeNode fa, int d) {
        if (node == null) {
            return false;
        }
        // 找到 x 或 y
        if (node.val == x || node.val == y) {
            // 之前已找到 x y 其中一个
            if (depth > 0) {
                return depth == d && father != fa;
            }
            depth = d;
            father = fa;
        }
        return dfs(node.left, node, d + 1) || dfs(node.right, node, d + 1);
    }
}
/*
993. 二叉树的堂兄弟节点
https://leetcode.cn/problems/cousins-in-binary-tree/description/

在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
提示：
二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。

递归。
depth 和 father 记录 d 和 fa 第一次的值。后面遇到再判等即可。
时间复杂度 O(n)。
 */