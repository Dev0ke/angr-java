public class Solution1026 {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        ans = Math.max(ans, Math.max(node.val - min, max - node.val));

        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}
/*
1026. 节点与其祖先之间的最大差值
https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/

给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
提示：
树中的节点数在 2 到 5000 之间。
0 <= Node.val <= 10^5

递归
 */