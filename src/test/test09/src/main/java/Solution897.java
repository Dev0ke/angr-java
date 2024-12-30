import java.util.ArrayList;
import java.util.List;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> orderList = new ArrayList<>();
        inorder(root, orderList);

        TreeNode cur = new TreeNode(-1);
        TreeNode dummy = cur;
        for (int order : orderList) {
            cur.right = new TreeNode(order);
            cur = cur.right;
        }
        return dummy.right;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        // 中序遍历
        list.add(root.val);
        inorder(root.right, list);
    }
}
/*
897. 递增顺序搜索树
https://leetcode.cn/problems/increasing-order-search-tree/

第 100 场周赛 T2。

给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
提示：
树中节点数的取值范围是 [1, 100]
0 <= Node.val <= 1000

中序遍历。
 */