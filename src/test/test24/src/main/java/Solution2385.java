import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2385 {
    private Map<Integer, TreeNode> faMap;

    public int amountOfTime(TreeNode root, int start) {
        // dfs 先找父节点
        faMap = new HashMap<>();
        dfs(root);

        TreeNode startNode = faMap.getOrDefault(start, root);
        if (startNode.val != start) {
            if (startNode.left != null && startNode.left.val == start) {
                startNode = startNode.left;
            } else {
                startNode = startNode.right;
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int step = -1;
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
        }
        return step;
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
2385. 感染二叉树需要的总时间
https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/

第 307 场周赛 T3。

给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
每分钟，如果节点满足以下全部条件，就会被感染：
- 节点此前还没有感染。
- 节点与一个已感染节点相邻。
返回感染整棵树需要的分钟数。
提示：
树中节点的数目在范围 [1, 10^5] 内
1 <= Node.val <= 1^05
每个节点的值 互不相同
树中必定存在值为 start 的节点

DFS + BFS
时间复杂度 O(n)
 */