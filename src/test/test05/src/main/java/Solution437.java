import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return preorder(root, targetSum, map, 0L);
    }

    private int preorder(TreeNode root, int targetSum, Map<Long, Integer> map, long path) {
        if (root == null) {
            return 0;
        }
        path += root.val;
        int cnt = map.getOrDefault(path - targetSum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        cnt += preorder(root.left, targetSum, map, path);
        cnt += preorder(root.right, targetSum, map, path);
        map.put(path, map.get(path) - 1);
        return cnt;
    }
}
/*
437. 路径总和 III
https://leetcode.cn/problems/path-sum-iii/

给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
提示:
二叉树的节点个数的范围是 [0,1000]
-10^9 <= Node.val <= 10^9
-1000 <= targetSum <= 1000

前序遍历。
 */