public class Solution979 {
    private int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d = dfs(node.left) + dfs(node.right) + node.val - 1;
        ans += Math.abs(d);
        return d;
    }
}
/*
979. 在二叉树中分配硬币
https://leetcode.cn/problems/distribute-coins-in-binary-tree/

给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。
在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。
返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。
提示：
树中节点的数目为 n
1 <= n <= 100
0 <= Node.val <= n
所有 Node.val 的值之和是 n

DFS
 */
