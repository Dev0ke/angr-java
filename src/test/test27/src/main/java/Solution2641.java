import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;

        // 双数组 BFS
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>(queue);
            queue.clear();

            // 求下一层的和
            int nextLevelSum = 0;
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    nextLevelSum += node.left.val;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    nextLevelSum += node.right.val;
                    queue.add(node.right);
                }
            }

            for (TreeNode node : tmp) {
                // 求堂兄弟节点的和
                int botherSum = (node.left == null ? 0 : node.left.val)
                        + (node.right == null ? 0 : node.right.val);
                if (node.left != null) {
                    node.left.val = nextLevelSum - botherSum;
                }
                if (node.right != null) {
                    node.right.val = nextLevelSum - botherSum;
                }
            }
        }
        return root;
    }
}
/*
2641. 二叉树的堂兄弟节点 II
https://leetcode.cn/problems/cousins-in-binary-tree-ii/

第 102 场双周赛 T3。

给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。
如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。
请你返回修改值之后，树的根 root 。
注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
提示：
树中节点数目的范围是 [1, 10^5] 。
1 <= Node.val <= 10^4

层序遍历。先算出下一层的和，再减去堂兄弟节点的和。
时间复杂度 O(n)
相似题目: 2411. 按位或最大的最小子数组长度
https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/
 */