import java.util.TreeSet;

public class Solution671 {
    private TreeSet<Integer> treeSet;

    public int findSecondMinimumValue(TreeNode root) {
        treeSet = new TreeSet<>();
        dfs(root);
        if (treeSet.size() > 1) {
            treeSet.pollFirst();
            return treeSet.pollFirst();
        }
        return -1;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        treeSet.add(treeNode.val);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
/*
671. 二叉树中第二小的节点
https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
如果第二小的值不存在的话，输出 -1 。
提示：
树中节点数目在范围 [1, 25] 内
1 <= Node.val <= 2^31 - 1
对于树中每个节点 root.val == min(root.left.val, root.right.val)

（没有技巧，全是暴力。。
 */