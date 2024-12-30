import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution863 {
    private Map<Integer, TreeNode> faMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> resList = new ArrayList<>();
        if (k == 0) {
            resList.add(target.val);
            return resList;
        }

        // dfs 先找父节点
        faMap = new HashMap<>();
        dfs(root);

        // bfs 找距离为 k 节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();

                // 左
                if (cur.left != null && !visited.contains(cur.left.val)) {
                    visited.add(cur.left.val);
                    queue.add(cur.left);
                }
                // 右
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    visited.add(cur.right.val);
                    queue.add(cur.right);
                }
                // 父
                if (faMap.containsKey(cur.val)) {
                    TreeNode father = faMap.get(cur.val);
                    if (!visited.contains(father.val)) {
                        visited.add(father.val);
                        queue.add(father);
                    }
                }
            }
            if (step == k) {
                for (TreeNode treeNode : queue) {
                    resList.add(treeNode.val);
                }
                break;
            }
        }
        return resList;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            faMap.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            faMap.put(node.right.val, node);
            dfs(node.right);
        }
    }
}
/*
863. 二叉树中所有距离为 K 的结点
https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/

给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
提示:
节点数在 [1, 500] 范围内
0 <= Node.val <= 500
Node.val 中所有值 不同
目标结点 target 是树上的结点。
0 <= k <= 1000

dfs 先找父节点
bfs 找距离为 k 节点
时间复杂度 O(n)
 */