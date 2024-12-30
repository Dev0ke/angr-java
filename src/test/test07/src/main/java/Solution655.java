import java.util.Arrays;
import java.util.List;

public class Solution655 {
    private int maxDepth;
    private String[][] ans;

    public List<List<String>> printTree(TreeNode root) {
        dfs(root, 0);

        int m = maxDepth + 1;
        int n = (1 << (maxDepth + 1)) - 1;
        ans = new String[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], "");
        }
        dfs2(root, 0, (n - 1) / 2);
        return Arrays.stream(ans).map(o -> Arrays.stream(o).toList()).toList();
    }

    private void dfs(TreeNode node, int d) {
        if (node == null) return;
        maxDepth = Math.max(maxDepth, d);
        dfs(node.left, d + 1);
        dfs(node.right, d + 1);
    }

    private void dfs2(TreeNode root, int x, int y) {
        if (root == null) return;
        ans[x][y] = String.valueOf(root.val);
        dfs2(root.left, x + 1, y - (1 << (maxDepth - x - 1)));
        dfs2(root.right, x + 1, y + (1 << (maxDepth - x - 1)));
    }
}
/*
655. 输出二叉树
https://leetcode.cn/problems/print-binary-tree/description/

给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
- 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
- 矩阵的列数 n 应该等于 2height+1 - 1 。
- 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
- 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
- 继续这一过程，直到树中的所有节点都妥善放置。
- 任意空单元格都应该包含空字符串 "" 。
返回构造得到的矩阵 res 。
提示：
树中节点数在范围 [1, 2^10] 内
-99 <= Node.val <= 99
树的深度在范围 [1, 10] 内

两遍 DFS。
第一遍 DFS：递归函数得到树的高度 h，以及与其相关的矩阵行列大小（并初始化矩阵）。
第二遍 DFS：根据填充规则，递归函数往矩阵进行填充。
时间复杂度 O(nm)。
 */