import java.util.ArrayList;
import java.util.List;

public class SolutionP1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        dfs(root, resList);
        return resList;
    }

    private void dfs(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, resList);
            if (root.right == null) {
                resList.add(root.left.val);
            }
        }
        if (root.right != null) {
            dfs(root.right, resList);
            if (root.left == null) {
                resList.add(root.right.val);
            }
        }
    }
}
/*
$1469. 寻找所有的独生节点
https://leetcode.cn/problems/find-all-the-lonely-nodes/

二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。数组的顺序 不限 。
提示：
 tree 中节点个数的取值范围是 [1, 1000]。
每个节点的值的取值范围是 [1, 10^6]。

DFS.
 */