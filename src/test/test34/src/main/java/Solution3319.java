import java.util.ArrayList;
import java.util.List;

public class Solution3319 {
    private List<int[]> nodes;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        nodes = new ArrayList<>();
        dfs(root);
        nodes.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
        if (nodes.size() < k) return -1;
        return nodes.get(k - 1)[1];
    }

    // sz, lvl
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        if (node.left == null && node.right == null) {
            nodes.add(new int[]{node.val, 1});
            return new int[]{1, 1};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int sz = l[0] + r[0] + 1;
        if (l[1] == r[1] && l[0] == (1 << l[1]) - 1 && r[0] == (1 << r[1]) - 1) {
            nodes.add(new int[]{node.val, sz});
        }
        return new int[]{sz, Math.max(l[1], r[1]) + 1};
    }
}
/*
3319. 第 K 大的完美二叉子树的大小
https://leetcode.cn/problems/k-th-largest-perfect-subtree-size-in-binary-tree/description/

第 419 场周赛 T2。

给你一棵 二叉树 的根节点 root 和一个整数k。
返回第 k 大的 完美二叉 子树 的大小，如果不存在则返回 -1。
完美二叉树 是指所有叶子节点都在同一层级的树，且每个父节点恰有两个子节点。
提示：
树中的节点数目在 [1, 2000] 范围内。
1 <= Node.val <= 2000
1 <= k <= 1024

dfs。维护 子树大小 和 层数。
 */