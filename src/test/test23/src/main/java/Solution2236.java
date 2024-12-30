public class Solution2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
/*
2236. 判断根结点是否等于子结点之和
https://leetcode.cn/problems/root-equals-sum-of-children/description/

给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
提示：
树只包含根结点、左子结点和右子结点
-100 <= Node.val <= 100

直接判断。
时间复杂度 O(1)。
 */