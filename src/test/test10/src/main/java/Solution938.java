public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int ans = (low <= root.val && root.val <= high) ? root.val : 0;
        ans += rangeSumBST(root.left, low, high);
        ans += rangeSumBST(root.right, low, high);
        return ans;
    }
}
/*
938. 二叉搜索树的范围和
https://leetcode.cn/problems/range-sum-of-bst/description/

给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
提示：
树中节点数目在范围 [1, 2 * 10^4] 内
1 <= Node.val <= 10^5
1 <= low <= high <= 10^5
所有 Node.val 互不相同

递归。感觉不用二叉搜索树的性质也无所谓。毕竟最坏时间复杂度都是 O(n)。
时间复杂度 O(n)。
 */