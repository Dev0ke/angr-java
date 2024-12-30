public class SolutionP285 {
    /**
     * 剑指 Offer II 053. 二叉搜索树中的中序后继
     * https://leetcode.cn/problems/P5rCT8/
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
/*
$285. 二叉搜索树中的中序后继
https://leetcode.cn/problems/inorder-successor-in-bst/

给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
节点 p 的后继是值比 p.val 大的节点中键值最小的节点。
提示：
树中节点的数目在范围 [1, 10^4] 内。
-10^5 <= Node.val <= 10^5
树中各节点的值均保证唯一。

利用二叉树的性质，由于没说明树是平衡的，因此平均是 O(logn) 最坏是 O(n)
时间复杂度 O(n)
空间复杂度 O(1)
 */