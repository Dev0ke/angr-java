import java.util.HashSet;
import java.util.Set;

public class SolutionP1214 {
    private int target;
    private Set<Integer> valSet;
    private boolean res;

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        this.target = target;
        valSet = new HashSet<>();
        res = false;

        dfs1(root1);
        dfs2(root2);
        return res;
    }

    private void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        valSet.add(node.val);
        dfs1(node.left);
        dfs1(node.right);
    }

    private void dfs2(TreeNode node) {
        if (node == null) {
            return;
        }
        if (valSet.contains(target - node.val)) {
            res = true;
        }
        dfs2(node.left);
        dfs2(node.right);
    }
}
/*
$1214. 查找两棵二叉搜索树之和
https://leetcode.cn/problems/two-sum-bsts/

给出两棵二叉搜索树的根节点 root1 和 root2 ，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
如果可以找到返回 True，否则返回 False。
提示：
每棵树上节点数在 [1, 5000] 范围内。
-10^9 <= Node.val, target <= 10^9

DFS + HashSet 暴力匹配
 */