import java.util.LinkedList;
import java.util.Queue;

public class SolutionP1602 {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                if (cur.val == u.val) {
                    // 返回与 u 所在层中距离最近的右侧节点，当 u 是所在层中最右侧的节点，返回 null 。
                    return (i + 1 < size) ? queue.remove() : null;
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return null;
    }
}
/*
$1602. 找到二叉树中最近的右侧节点
https://leetcode.cn/problems/find-nearest-right-node-in-binary-tree/

给定一棵二叉树的根节点 root 和树中的一个节点 u ，返回与 u 所在层中距离最近的右侧节点，当 u 是所在层中最右侧的节点，返回 null 。
提示:
树中节点个数的范围是 [1, 10^5] 。
1 <= Node.val <= 10^5
树中所有节点的值是唯一的。
u 是以 root 为根的二叉树的一个节点。

层序遍历。
 */