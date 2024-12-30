public class Solution1457 {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode x, int mask) {
        if (x == null) return 0;
        mask ^= 1 << x.val; // x.val 出现次数的奇偶性
        if (x.left != null || x.right != null) {
            return dfs(x.left, mask) + dfs(x.right, mask);
        }
//        return (mask & (mask - 1)) == 0 ? 1 : 0;
        return Integer.bitCount(mask) <= 1 ? 1 : 0;
    }
}
/*
1457. 二叉树中的伪回文路径
https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/

给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
提示：
给定二叉树的节点数目在范围 [1, 10^5] 内
1 <= Node.val <= 9

DFS + 前缀和 + 按位异或性质
时间复杂度 O(n)。
相似题目: 2791. 树中可以形成回文的路径数
https://leetcode.cn/problems/count-paths-that-can-form-a-palindrome-in-a-tree/
 */