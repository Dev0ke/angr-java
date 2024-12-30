import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            // 逐层 + 1
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                // 第一个叶子返回 即 最小深度
                if (cur.left == null && cur.right == null) {
                    return minDepth;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return minDepth;
    }
}
/*
111. 二叉树的最小深度
https://leetcode.cn/problems/minimum-depth-of-binary-tree/

给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
提示：
树中节点数的范围在 [0, 10^5] 内
-1000 <= Node.val <= 1000

二叉树层序遍历。
 */