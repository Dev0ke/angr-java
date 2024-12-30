public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 后缀遍历
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树作为右子树
        root.left = null;
        root.right = left;
        // 将原先的右子树接到当前右子树的末端
        TreeNode rootNode = root;
        while (rootNode.right != null) {
            rootNode = rootNode.right;
        }
        rootNode.right = right;
    }
}
/*
114. 二叉树展开为链表
https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

给你二叉树的根结点 root ，请你将它展开为一个单链表：
- 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
- 展开后的单链表应该与二叉树 先序遍历 顺序相同。
   1
  / \
 2   5
/ \   \
3  4   6
=>
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
提示：
树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100
进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

二叉树后序遍历
 */