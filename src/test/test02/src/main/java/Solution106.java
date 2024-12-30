import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    private int[] postorder;
    private Map<Integer, Integer> idxMap;
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        // 后序遍历
        this.postorder = postorder;
        // 中序遍历转 HashMap
        this.idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }

        // 从后序遍历的最后一个元素开始
        postIdx = n - 1;
        return helper(0, n - 1);
    }

    private TreeNode helper(int inLeft, int inRight) {
        // 如果这里没有节点构造二叉树了，就结束
        if (inLeft > inRight) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        // 根据 root 所在位置分成左右两棵子树
        int inRoot = idxMap.get(rootVal);

        // 下标减一
        postIdx--;
        // 构造右子树
        root.right = helper(inRoot + 1, inRight);
        // 构造左子树
        root.left = helper(inLeft, inRoot - 1);
        return root;
    }
}
/*
106. 从中序与后序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
提示:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder 和 postorder 都由 不同 的值组成
postorder 中每一个值都在 inorder 中
inorder 保证是树的中序遍历
postorder 保证是树的后序遍历

时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 105. 从前序与中序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */