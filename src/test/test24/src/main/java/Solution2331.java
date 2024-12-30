public class Solution2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return root.val == 1;
        } else {
            if (root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}
/*
2331. 计算布尔二叉树的值
https://leetcode.cn/problems/evaluate-boolean-binary-tree/

第 82 场双周赛 T1。

给你一棵 完整二叉树 的根，这棵树有以下特征：
- 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
- 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
计算 一个节点的值方式如下：
- 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
- 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
返回根节点 root 的布尔运算值。
完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
叶子节点 是没有孩子的节点。
提示：
树中节点数目在 [1, 1000] 之间。
0 <= Node.val <= 3
每个节点的孩子数为 0 或 2 。
叶子节点的值为 0 或 1 。
非叶子节点的值为 2 或 3 。

递归
 */