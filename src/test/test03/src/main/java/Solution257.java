import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        dfs(root, "", resList);
        return resList;
    }

    private void dfs(TreeNode root, String path, List<String> resList) {
        if (root == null) {
            return;
        }
        path += root.val;
        // 叶子节点
        if (root.left == null && root.right == null) {
            resList.add(path);
        } else {
            path += "->";
            dfs(root.left, path, resList);
            dfs(root.right, path, resList);
        }
    }
}
/*
257. 二叉树的所有路径
https://leetcode.cn/problems/binary-tree-paths/

给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
叶子节点 是指没有子节点的节点。
提示：
树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100

回溯
 */