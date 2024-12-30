public class SolutionP2689 {
    public char getKthCharacter(RopeTreeNode root, int k) {
        if (root.len == 0) {
            return root.val.charAt(k - 1);
        }
        RopeTreeNode left = root.left, right = root.right;
        int leftLen = left != null ? Math.max(left.len, left.val.length()) : 0;
        if (k <= leftLen) {
            return getKthCharacter(left, k);
        } else {
            return getKthCharacter(right, k - leftLen);
        }
    }

    // UT
    static class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        RopeTreeNode() {
        }

        RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

        RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
            this.len = len;
            this.val = "";
            this.left = left;
            this.right = right;
        }
    }
}
/*
$2689. 从 Rope 树中提取第 K 个字符
https://leetcode.cn/problems/extract-kth-character-from-the-rope-tree/description/

给定一个二叉树的根节点 root 和整数 k。除了左右孩子之外，该树的每个节点还有另外两个属性：一个仅包含小写英文字母（可能为空）的 字符串 node.val 和一个非负整数 node.len。这棵树中有两种类型的节点：
- 叶子节点：这些节点没有子节点，node.len = 0，node.val 是一个 非空 字符串。
- 内部节点：这些节点至少有一个子节点（最多两个子节点），node.len > 0，node.val 是一个 空 字符串。
上述描述的树被称为 Rope 二叉树。现在我们用以下递归方式定义 S[node]：
- 如果 node 是一个叶子节点，则 S[node] = node.val，
- 否则，如果 node 是一个内部节点，则 S[node] = concat(S[node.left], S[node.right])，且 S[node].length = node.len。
返回字符串 S[root] 的第 k 个字符。
注意：如果 s 和 p 是两个字符串，则 concat(s, p) 是将字符串 p 连接到 s 后面的字符串。例如，concat("ab", "zz") = "abzz"。
提示：
这棵树的节点数量在区间 [1, 10^3]
node.val 仅包含小写英文字母
0 <= node.val.length <= 50
0 <= node.len <= 104
对于叶子节点， node.len = 0 且 node.val 是非空的
对于内部节点， node.len > 0  且 node.val 为空
1 <= k <= S[root].length

 */