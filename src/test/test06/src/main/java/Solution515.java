import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        if (root != null) {
            queue1.add(root);
        }
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.remove();
            max = Math.max(max, node.val);
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
            if (queue1.isEmpty()) {
                res.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
            }
        }
        return res;
    }
}
/*
515. 在每个树行中找最大值
https://leetcode.cn/problems/find-largest-value-in-each-tree-row/

给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
提示：
二叉树的节点个数的范围是 [0,10^4]
-2^31 <= Node.val <= 2^31 - 1

二叉树“按层”。两个队列实现二叉树广搜
相似题目: 199. 二叉树的右视图
https://leetcode.cn/problems/binary-tree-right-side-view/
513. 找树左下角的值
https://leetcode.cn/problems/find-bottom-left-tree-value/
 */