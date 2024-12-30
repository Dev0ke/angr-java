import java.util.LinkedList;
import java.util.Queue;

public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0, maxLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            level++;
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
            // update
            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
/*
1161. 最大层内元素和
https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/

给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
提示：
树中的节点数在 [1, 10^4]范围内
-10^5 <= Node.val <= 10^5

层序遍历，层内求和。
 */