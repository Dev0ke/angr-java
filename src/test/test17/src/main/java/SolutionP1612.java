import java.util.Arrays;

public class SolutionP1612 {
    public boolean checkEquivalence(Node root1, Node root2) {
        return Arrays.equals(calc(root1), calc(root2));
    }

    private void merge(int[] ans, int[] l, int[] r, char op) {
        for (int i = 0; i < 26; ++i) {
            if (op == '+') ans[i] = l[i] + r[i];
            if (op == '-') ans[i] = l[i] - r[i];
        }
    }

    private int[] calc(Node p) {
        int[] ans = new int[26];
        if (p == null) return ans;
        if (p.val == '+' || p.val == '-') {
            int[] left = calc(p.left);
            int[] right = calc(p.right);
            merge(ans, left, right, p.val);
            return ans;
        }
        ans[p.val - 'a']++;
        return ans;
    }

    // UT
    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
/*
$1612. 检查两棵二叉表达式树是否等价
https://leetcode.cn/problems/check-if-two-expression-trees-are-equivalent/description/

二叉表达式树是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。 叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 个子节点的节点）表示运算符。在本题中，我们只考虑 '+' 运算符（即加法）。
给定两棵二叉表达式树的根节点 root1 和 root2 。如果两棵二叉表达式树等价，返回 true ，否则返回 false 。
当两棵二叉搜索树中的变量取任意值，分别求得的值都相等时，我们称这两棵二叉表达式树是等价的。
提示：
两棵树中的节点个数相等，且节点个数为范围 [1, 4999] 内的奇数。
Node.val 是 '+' 或小写英文字母。
给定的树保证是有效的二叉表达式树。
进阶：当你的答案需同时支持 '-' 运算符（减法）时，你该如何修改你的答案

记录每一变量的个数，支持加减操作
https://leetcode.cn/problems/check-if-two-expression-trees-are-equivalent/solutions/453074/ji-lu-mei-yi-bian-liang-de-ge-shu-zhi-chi-jia-jian/
 */