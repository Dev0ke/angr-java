import java.util.ArrayList;
import java.util.List;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        traverse(root1, leafList1);
        traverse(root2, leafList2);
        return leafList1.equals(leafList2);
    }

    private void traverse(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        } else {
            traverse(root.left, leafList);
            traverse(root.right, leafList);
        }
    }
}
/*
872. 叶子相似的树
https://leetcode.cn/problems/leaf-similar-trees/

第 94 场周赛 T1。

请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
提示：
给定的两棵树结点数在 [1, 200] 范围内
给定的两棵树上的值在 [0, 200] 范围内

求出两棵树的叶值序列，然后进行比较即可。
 */