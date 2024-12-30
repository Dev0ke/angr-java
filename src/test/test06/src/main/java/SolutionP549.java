public class SolutionP549 {
    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    // increase, decrease
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int incr = 1;
        int decr = 1;
        if (root.left != null) {
            int[] left = dfs(root.left);
            if (root.val == root.left.val + 1) {
                decr = Math.max(decr, left[1] + 1);
            } else if (root.val == root.left.val - 1) {
                incr = Math.max(incr, left[0] + 1);
            }
        }
        if (root.right != null) {
            int[] right = dfs(root.right);
            if (root.val == root.right.val + 1) {
                decr = Math.max(decr, right[1] + 1);
            } else if (root.val == root.right.val - 1) {
                incr = Math.max(incr, right[0] + 1);
            }
        }
        max = Math.max(max, decr + incr - 1);
        return new int[]{incr, decr};
    }
}
/*
$549. 二叉树中最长的连续序列
https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence-ii/

给定二叉树的根 root ，返回树中最长连续路径的长度。
连续路径是路径中相邻节点的值相差 1 的路径。此路径可以是增加或减少。
- 例如， [1,2,3,4] 和 [4,3,2,1] 都被认为有效，但路径 [1,2,4,3] 无效。
另一方面，路径可以是子-父-子顺序，不一定是父子顺序。
提示：
树上所有节点的值都在 [1, 3 * 10^4] 范围内。
-3 * 10^4 <= Node.val <= 3 * 10^4

相似题目: $298. 二叉树最长连续序列
https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/
 */