public class SolutionP298 {
    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root, null, 0);
        return max;
    }

    // x:当前节点 fa:父节点 len:长度
    private void dfs(TreeNode x, TreeNode fa, int len) {
        if (x == null) {
            return;
        }
        len = (fa != null && fa.val + 1 == x.val) ? len + 1 : 1;
        max = Math.max(max, len);
        dfs(x.left, x, len);
        dfs(x.right, x, len);
    }
}
/*
$298. 二叉树最长连续序列
https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/

给你一棵指定的二叉树的根节点 root ，请你计算其中 最长连续序列路径 的长度。
最长连续序列路径 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，反过来是不可以的。
提示：
树中节点的数目在范围 [1, 3 * 10^4] 内
-3 * 10^4 <= Node.val <= 3 * 10^4

相似题目: $549. 二叉树中最长的连续序列
https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence-ii/
 */