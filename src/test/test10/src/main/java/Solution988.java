public class Solution988 {
    private String ans;

    public String smallestFromLeaf(TreeNode root) {
        ans = "~";
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            String cur = sb.reverse().toString();
            sb.reverse();
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
/*
988. 从叶结点开始的最小字符串
https://leetcode.cn/problems/smallest-string-starting-from-leaf/description/

给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
- 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
节点的叶节点是没有子节点的节点。
提示：
给定树的结点数在 [1, 8500] 范围内
0 <= Node.val <= 25

递归。然后“打擂台”，无需所有组合找出来再排序。
时间复杂度 O(nlogn)。sb 翻转与比较时间为 O(L)。当完全平衡树时，L = logn。
 */