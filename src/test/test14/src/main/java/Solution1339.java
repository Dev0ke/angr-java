public class Solution1339 {
    private static final int MOD = (int) (1e9 + 7);
    private long sum, closest;

    // 因为树中节点的值不唯一，所以难以用数组进行持久化处理
    public int maxProduct(TreeNode root) {
        dfs(root);
        dfs2(root);
        long ans = closest * (sum - closest) % MOD;
        return (int) ans;
    }

    private void dfs(TreeNode x) {
        if (x == null) return;
        sum += x.val;
        dfs(x.left);
        dfs(x.right);
    }

    private int dfs2(TreeNode x) {
        if (x == null) return 0;
        int cur = x.val + dfs2(x.left) + dfs2(x.right);
        if (Math.abs(closest * 2 - sum) > Math.abs(cur * 2L - sum)) {
            closest = cur;
        }
        return cur;
    }
}
/*
1339. 分裂二叉树的最大乘积
https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/description/

给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
提示：
每棵树最多有 50000 个节点，且至少有 2 个节点。
每个节点的值在 [1, 10000] 之间。

两遍 DFS。
时间复杂度 O(n)。
 */