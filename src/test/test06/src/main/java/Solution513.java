import java.util.ArrayDeque;
import java.util.Queue;

public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);
        int bottomLeft = root.val;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.remove();
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
                if (!queue1.isEmpty()) {
                    bottomLeft = queue1.element().val;
                }
            }
        }
        return bottomLeft;
    }
}
/*
513. 找树左下角的值
https://leetcode.cn/problems/find-bottom-left-tree-value/

给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。
提示:
二叉树的节点个数的范围是 [1,10^4]
-2^31 <= Node.val <= 2^31 - 1

二叉树“按层”。两个队列实现二叉树广搜
相似题目: 199. 二叉树的右视图
https://leetcode.cn/problems/binary-tree-right-side-view/
515. 在每个树行中找最大值
https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */