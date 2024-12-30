public class Solution687 {
    private int longest;

    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        dfs(root);
        return longest;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        longest = Math.max(longest, left + right);
        return Math.max(left, right);
    }
}
/*
687. 最长同值路径
https://leetcode.cn/problems/longest-univalue-path/

给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
两个节点之间的路径长度 由它们之间的边数表示。
提示:
树的节点数的范围是 [0, 10^4]
-1000 <= Node.val <= 1000
树的深度将不超过 1000

递归。
 */