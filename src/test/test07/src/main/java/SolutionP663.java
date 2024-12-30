import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP663 {
    private Deque<Integer> stack;

    public boolean checkEqualTree(TreeNode root) {
        stack = new ArrayDeque<>();
        int sum = dfs(root);
        if (sum % 2 == 0) {
            // 排除根节点
            stack.pop();
            while (!stack.isEmpty()) {
                if (stack.pop() == sum / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        stack.push(dfs(node.left) + dfs(node.right) + node.val);
        return stack.element();
    }
}
/*
$663. 均匀树划分
https://leetcode.cn/problems/equal-tree-partition/

给定一棵有 n 个结点的二叉树，你的任务是检查是否可以通过去掉树上的一条边将树分成两棵，且这两棵树结点之和相等。
注释 :
树上结点的权值范围 [-100000, 100000]。
1 <= n <= 10000

Trick：用栈剔除根节点
 */