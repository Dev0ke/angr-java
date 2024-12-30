import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionP545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        if (!isLeaf(root)) {
            resList.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                resList.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        addLeaves(root, resList);

        Deque<Integer> stack = new ArrayDeque<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                stack.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!stack.isEmpty()) {
            resList.add(stack.pop());
        }
        return resList;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeaves(TreeNode node, List<Integer> resList) {
        if (isLeaf(node)) {
            resList.add(node.val);
        } else {
            if (node.left != null) {
                addLeaves(node.left, resList);
            }
            if (node.right != null) {
                addLeaves(node.right, resList);
            }
        }
    }
}
/*
$545. 二叉树的边界
https://leetcode.cn/problems/boundary-of-binary-tree/

二叉树的 边界 是由 根节点 、左边界 、按从左到右顺序的 叶节点 和 逆序的右边界 ，按顺序依次连接组成。
左边界 是满足下述定义的节点集合：
- 根节点的左子节点在左边界中。如果根节点不含左子节点，那么左边界就为 空 。
- 如果一个节点在左边界中，并且该节点有左子节点，那么它的左子节点也在左边界中。
- 如果一个节点在左边界中，并且该节点 不含 左子节点，那么它的右子节点就在左边界中。
- 最左侧的叶节点 不在 左边界中。
右边界 定义方式与 左边界 相同，只是将左替换成右。即，右边界是根节点右子树的右侧部分；叶节点 不是 右边界的组成部分；如果根节点不含右子节点，那么右边界为 空 。
叶节点 是没有任何子节点的节点。对于此问题，根节点 不是 叶节点。
给你一棵二叉树的根节点 root ，按顺序返回组成二叉树 边界 的这些值。
提示：
树中节点的数目在范围 [1, 10^4] 内
-1000 <= Node.val <= 1000

模拟。将问题划分成三个子问题：左边界、叶子节点和右边界。
时间复杂度 O(n)
空间复杂度 O(n)
 */