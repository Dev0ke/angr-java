import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            resList.add(curLevel);
        }
        Collections.reverse(resList);
        return resList;
    }
}
/*
107. 二叉树的层序遍历 II
https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/

给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其自底向上的层序遍历为：
[
  [15,7],
  [9,20],
  [3]
]
提示：
树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000

二叉树层序遍历。
相似题目: 102. 二叉树的层序遍历
https://leetcode.cn/problems/binary-tree-level-order-traversal/
第 102 题基础上 Collections.reverse(resList);
 */