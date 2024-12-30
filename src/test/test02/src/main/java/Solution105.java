import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> idxMap;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        // 前序遍历
        this.preorder = preorder;
        // 中序遍历转 HashMap
        this.idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }

        return helper(0, n - 1, 0);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int rootVal = preorder[preLeft];
        // 在中序遍历中定位根节点
        int inRoot = idxMap.get(rootVal);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(rootVal);

        // 得到左子树中的节点数目
        int leftSubtreeSize = inRoot - inLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = helper(preLeft + 1, preLeft + leftSubtreeSize, inLeft);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = helper(preLeft + leftSubtreeSize + 1, preRight, inRoot + 1);
        return root;
    }
}
/*
105. 从前序与中序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列

对于任意一颗树而言，前序遍历的形式总是: [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是: [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 106. 从中序与后序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */