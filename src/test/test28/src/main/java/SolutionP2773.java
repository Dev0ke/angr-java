import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP2773 {
    public int heightOfTree(TreeNode root) {
        if (isLeaf(root)) return 0;
        int depth = -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (!isLeaf(node)) {
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
        }
        return depth;
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null || node.right == null) return false;
        return node.left.right == node && node.right.left == node;
    }
}
/*
$2773. 特殊二叉树的高度
https://leetcode.cn/problems/height-of-special-binary-tree/description/

给定一棵具有 n 个节点的 特殊 二叉树的根节点 root 。特殊二叉树的节点编号从 1 到 n 。假设这棵树有 k 个叶子，顺序如下：b1 < b2 < ... < bk 。
这棵树的叶子节点有一个 特殊 属性 ！对于每个叶子节点 bi ，满足以下条件：
- 如果 i < k ，则 bi 的右子节点为 bi + 1 ；否则为 b1 。
- 如果 i > 1 ，则 bi 的左子节点为 bi - 1 ；否则为 bk 。
返回给定树的高度。
注意：二叉树的高度是指从根节点到任何其他节点的 最长路径 的长度。
提示：
n 为树中节点的数量
2 <= n <= 10^4
1 <= node.val <= n
输入保证每个 node.val 的值是唯一的。

BFS。
 */