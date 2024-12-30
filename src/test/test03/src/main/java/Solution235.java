public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = root;
        while (true) {
            if (p.val < treeNode.val && q.val < treeNode.val) {
                treeNode = treeNode.left;
            } else if (p.val > treeNode.val && q.val > treeNode.val) {
                treeNode = treeNode.right;
            } else {
                break;
            }
        }
        return treeNode;
    }
}
/*
235. 二叉搜索树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。

一次遍历，利用好二叉搜索树的特性。
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: 236. 二叉树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */