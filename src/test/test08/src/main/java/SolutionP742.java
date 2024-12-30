import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionP742 {
    private Map<TreeNode, List<TreeNode>> adj;

    public int findClosestLeaf(TreeNode root, int k) {
        // 树转图
        adj = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        for (TreeNode node : adj.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                visited.add(node);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode u = queue.remove();
            if (adj.get(u).size() == 1) {
                return u.val;
            }

            for (TreeNode v : adj.get(u)) {
                if (v != null && !visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return -1;
    }

    private void dfs(TreeNode u, TreeNode fa) {
        if (u == null) return;
        adj.computeIfAbsent(u, key -> new ArrayList<>()).add(fa);
        adj.computeIfAbsent(fa, key -> new ArrayList<>()).add(u);
        dfs(u.left, u);
        dfs(u.right, u);
    }
}
/*
$742. 二叉树最近的叶节点
https://leetcode.cn/problems/closest-leaf-in-a-binary-tree/

给定一个 每个结点的值互不相同 的二叉树，和一个目标整数值 k，返回 树中与目标值 k  最近的叶结点 。 
与叶结点最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少。而且，当一个结点没有孩子结点时称其为叶结点。
提示：
二叉树节点数在 [1, 1000] 范围内
1 <= Node.val <= 1000
每个节点值都 不同
给定的二叉树中有某个结点使得 node.val == k

树转图 + BFS
时间复杂度 O(n)
 */