import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP3157 {
    public int minimumLevel(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        long minSum = root.val;
        int minLevel = 1;
        int curLevel = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode o = q.remove();
                sum += o.val;
                if (o.left != null) q.add(o.left);
                if (o.right != null) q.add(o.right);
            }
            if (minSum > sum) {
                minSum = sum;
                minLevel = curLevel;
            }
            curLevel++;
        }
        return minLevel;
    }
}
/*
$3157. 找到具有最小和的树的层数
https://leetcode.cn/problems/find-the-level-of-tree-with-minimum-sum/description/

给定一棵二叉树的根 root，其中每个节点有一个值，返回树中 层和最小 的层数（如果相等，返回 最低 的层数）。
注意 树的根节点在第一层，其它任何节点的层数是它到根节点的距离+1。
提示：
树中节点数量的范围是 [1, 10^5]。
1 <= Node.val <= 10^9

BFS 层序遍历。
时间复杂度 O(n)。
 */