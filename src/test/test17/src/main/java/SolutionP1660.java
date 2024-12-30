import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionP1660 {
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int curLen = q.size();
            Set<TreeNode> nextLevel = new HashSet<>();
            for (int i = 0; i < curLen; i++) {
                TreeNode p = q.remove();
                if (p.right != null) {
                    if (nextLevel.contains(p.right.right)) {
                        p.right = null;
                        return root;
                    } else {
                        q.add(p.right);
                        nextLevel.add(p.right);
                    }
                }
                if (p.left != null) {
                    if (nextLevel.contains(p.left.right)) {
                        p.left = null;
                        return root;
                    } else {
                        q.add(p.left);
                        nextLevel.add(p.left);
                    }
                }
            }
        }
        return null;
    }
}
/*
$1660. 纠正二叉树
https://leetcode.cn/problems/correct-a-binary-tree/description/

你有一棵二叉树，这棵二叉树有个小问题，其中有且只有一个无效节点，它的右子节点错误地指向了与其在同一层且在其右侧的一个其他节点。
给定一棵这样的问题二叉树的根节点 root ，将该无效节点及其所有子节点移除（除被错误指向的节点外），然后返回新二叉树的根结点。
自定义测试用例：
测试用例的输入由三行组成：
- TreeNode root
- int fromNode （在 correctBinaryTree 中不可见）
- int toNode （在 correctBinaryTree 中不可见）
当以 root 为根的二叉树被解析后，值为 fromNode 的节点 TreeNode 将其右子节点指向值为 toNode 的节点 TreeNode 。然后， root 传入 correctBinaryTree 的参数中。
提示:
树中节点个数的范围是 [3, 10^4] 。
-10^9 <= Node.val <= 10^9
所有的 Node.val 都是互不相同的。
fromNode != toNode
fromNode 和 toNode 将出现在树中的同一层。
toNode 在 fromNode 的右侧。
fromNode.right 在测试用例的树中建立后为 null 。

BFS。每层先右后左。
 */