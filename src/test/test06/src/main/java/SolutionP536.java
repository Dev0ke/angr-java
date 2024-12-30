public class SolutionP536 {
    public TreeNode str2tree(String s) {
        int len = s.length();

        // 特判
        if (len == 0) {
            return null;
        }
        int pos = s.indexOf("(");
        if (pos == -1) {
            return new TreeNode(Integer.parseInt(s));
        }

        int rootVal = Integer.parseInt(s.substring(0, pos));
        TreeNode root = new TreeNode(rootVal);

        // 是否平衡 '(' +1, ')' -1
        int balance = 0;
        for (int i = pos; i < len; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                balance--;
            }

            if (balance == 0) {
                // root(left)(right)
                // ---------i
                root.left = str2tree(s.substring(pos + 1, i));
                // 不一定有右节点
                if (i + 2 < len) {
                    root.right = str2tree(s.substring(i + 2, len - 1));
                }
                break;
            }
        }
        return root;
    }
}
/*
$536. 从字符串生成二叉树
https://leetcode.cn/problems/construct-binary-tree-from-string/

你需要用一个包括括号和整数的字符串构建一棵二叉树。
输入的字符串代表一棵二叉树。它包括整数和随后的 0 、1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。
若存在子结点，则从左子结点开始构建。
提示：
0 <= s.length <= 3 * 10^4
输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
空树由 "" 而非"()"表示。

字符串处理 + 递归
注意右子树不一定存在。
 */