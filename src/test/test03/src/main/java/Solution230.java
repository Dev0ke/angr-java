import java.util.ArrayList;
import java.util.List;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, k, inorderList);
        return inorderList.get(k - 1);
    }

    private void inorder(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, list);
        // 中序遍历
        if (list.size() >= k) {
            return;
        }
        list.add(root.val);

        inorder(root.right, k, list);
    }
}
/*
230. 二叉搜索树中第K小的元素
https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
提示：
树中的节点数为 n 。
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4
进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？

前置知识: 二叉搜索树的中序遍历是按照键增加的顺序进行的。
 */