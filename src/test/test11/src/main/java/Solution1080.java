public class Solution1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);
        }
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }
        // 如果 root 儿子都被删除，root 也删除
        return root.left == null && root.right == null ? null : root;
    }
}
/*
1080. 根到叶路径上的不足节点
https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/

给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
叶子节点，就是没有子节点的节点。
提示：
树中节点数目在范围 [1, 5000] 内
-10^5 <= Node.val <= 10^5
-10^9 <= limit <= 10^9

DFS
时间复杂度 O(n)
 */