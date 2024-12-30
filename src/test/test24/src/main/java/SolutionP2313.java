public class SolutionP2313 {
    private static final int FALSE = 0, TRUE = 1, OR = 2, AND = 3, XOR = 4, NOT = 5;

    public int minimumFlips(TreeNode root, boolean result) {
        int[] ans = dfs(root);
        return result ? ans[0] : ans[1];
    }

    // 把子节点变成 true/false 的操作次数
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        if (x.val == TRUE) return new int[]{0, 1};
        if (x.val == FALSE) return new int[]{1, 0};
        int[] L = dfs(x.left), R = dfs(x.right);
        if (x.val == OR) return new int[]{Math.min(L[0], R[0]), L[1] + R[1]};
        if (x.val == AND) return new int[]{L[0] + R[0], Math.min(L[1], R[1])};
        if (x.val == XOR) return new int[]{Math.min(L[0] + R[1], L[1] + R[0]),
                Math.min(L[0] + R[0], L[1] + R[1])};
        if (x.val == NOT) return new int[]{L[1] + R[1], L[0] + R[0]};
        return new int[2];
    }
}
/*
$2313. 二叉树中得到结果所需的最少翻转次数
https://leetcode.cn/problems/minimum-flips-in-binary-tree-to-get-result/description/

给定二叉树的根 root，具有以下属性:
- 叶节点 的值为 0 或 1，分别表示 false 和 true。
- 非叶节点的值为 2、3、4、5，分别表示布尔运算 OR, AND, XOR, NOT。
您还将得到一个布尔型 result，这是 root 节点的期望 评价 结果。
对节点的评价计算如下:
- 如果节点是叶节点，则评价是节点的 值，即 true 或 false.
- 否则, 将其值的布尔运算应用于子节点的 评价，该节点的 评价 即为布尔运算后的结果。
在一个操作中，您可以 翻转 一个叶节点，这将导致一个 false 节点变为 true 节点，一个 true 节点变为 false 节点。
返回需要执行的最小操作数，以使 root 的评价得到 result。可以证明，总有办法达到 result。
叶节点 是没有子节点的节点。
注意: NOT 节点只有左孩子或只有右孩子，但其他非叶节点同时拥有左孩子和右孩子。
提示:
树中的节点数在 [1, 10^5] 范围内。
0 <= Node.val <= 5
OR, AND, XOR 节点有 2 个子节点。
NOT 只有一个 1 子节点。
叶节点的值为 0 或 1.
非叶节点的值为2, 3, 4, 5.

树形 DP。
相似题目: 1896. 反转表达式值的最少操作次数
https://leetcode.cn/problems/minimum-cost-to-change-the-final-value-of-expression/description/
 */