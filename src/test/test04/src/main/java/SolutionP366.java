import java.util.ArrayList;
import java.util.List;

public class SolutionP366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = dfs(root, list);
            resList.add(list);
        }
        return resList;
    }

    private TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        return root;
    }
}
/*
$366. 寻找二叉树的叶子节点
https://leetcode.cn/problems/find-leaves-of-binary-tree/

给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
依次从左到右，每次收集并删除所有的叶子节点
重复如上过程直到整棵树为空
示例:
输入: [1,2,3,4,5]
          1
         / \
        2   3
       / \     
      4   5    
输出: [[4,5,3],[2],[1]]

递归。
 */