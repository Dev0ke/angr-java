public class Solution606 {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return String.valueOf(root.val);
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")"
                + "(" + tree2str(root.right) + ")";
    }
}
/*
606. 根据二叉树创建字符串
https://leetcode.cn/problems/construct-string-from-binary-tree/description/

给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
提示：
树中节点的数目范围是 [1, 10^4]
-1000 <= Node.val <= 1000

递归。
时间复杂度 O(n)
 */