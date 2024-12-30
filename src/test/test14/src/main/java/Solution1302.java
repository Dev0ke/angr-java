import java.util.LinkedList;
import java.util.Queue;

public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                sum += cur.val;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res = sum;
        }
        return res;
    }
}
/*
1302. 层数最深叶子节点的和
https://leetcode.cn/problems/deepest-leaves-sum/

给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
提示：
树中节点数目在范围 [1, 10^4] 之间。
1 <= Node.val <= 100

二叉树层序遍历。
 */