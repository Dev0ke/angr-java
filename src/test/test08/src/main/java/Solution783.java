public class Solution783 {
    private int min;
    private int pre;

    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left);

        // 中序遍历
        if (pre == -1) {
            pre = treeNode.val;
        } else {
            min = Math.min(min, treeNode.val - pre);
            pre = treeNode.val;
        }

        dfs(treeNode.right);
    }
}
/*
783. 二叉搜索树节点最小距离
https://leetcode.cn/problems/minimum-distance-between-bst-nodes/

给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。
提示：
树中节点的数目范围是 [2, 100]
0 <= Node.val <= 10^5

同: 530. 二叉搜索树的最小绝对差
https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 */
