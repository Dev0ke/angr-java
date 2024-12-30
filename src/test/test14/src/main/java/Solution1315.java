import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1315 {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.val % 2 == 0) {
                if (node.left != null) {
                    if (node.left.left != null) ans += node.left.left.val;
                    if (node.left.right != null) ans += node.left.right.val;
                }
                if (node.right != null) {
                    if (node.right.left != null) ans += node.right.left.val;
                    if (node.right.right != null) ans += node.right.right.val;
                }
            }
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return ans;
    }
}
/*
1315. 祖父节点值为偶数的节点和
https://leetcode.cn/problems/sum-of-nodes-with-even-valued-grandparent/description/

给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
- 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。
提示：
树中节点的数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。

BFS。
时间复杂度 O(n)。
 */