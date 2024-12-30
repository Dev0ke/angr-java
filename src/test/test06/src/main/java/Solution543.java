public class Solution543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
/*
543. 二叉树的直径
https://leetcode.cn/problems/diameter-of-binary-tree/

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例 :
给定二叉树
          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
注意：两结点之间的路径长度是以它们之间边的数目表示。

树形 DP
相似题目: 124. 二叉树中的最大路径和
https://leetcode.cn/problems/binary-tree-maximum-path-sum/
$1522. N 叉树的直径
https://leetcode.cn/problems/diameter-of-n-ary-tree/
 */