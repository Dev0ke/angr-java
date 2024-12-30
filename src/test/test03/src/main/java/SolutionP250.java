public class SolutionP250 {
    private int cnt;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cnt = 0;
        dfs(root);
        return cnt;
    }

    private boolean dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            cnt++;
            return true;
        }

        boolean uniVal = true;
        if (node.left != null) {
            uniVal = dfs(node.left) && node.left.val == node.val;
        }
        if (node.right != null) {
            // 不能写成 uniVal && dfs(node.right)
            uniVal = dfs(node.right) && uniVal && node.right.val == node.val;
        }
        if (!uniVal) {
            return false;
        }
        cnt++;
        return true;
    }

}
/*
$250. 统计同值子树
https://leetcode.cn/problems/count-univalue-subtrees/

给定一个二叉树，统计该二叉树数值相同的子树个数。
同值子树是指该子树的所有节点都拥有相同的数值。
示例：
输入: root = [5,1,5,5,5,null,5]
              5
             / \
            1   5
           / \   \
          5   5   5
输出: 4
Constraints:
The number of the node in the tree will be in the range [0, 1000].
-1000 <= Node.val <= 1000

递归
 */