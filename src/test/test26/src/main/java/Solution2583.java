import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sumList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            sumList.add(sum);
        }

        // 第 K 大
        sumList.sort(Comparator.reverseOrder());
        return k - 1 < sumList.size() ? sumList.get(k - 1) : -1;
    }
}
/*
2583. 二叉树中的第 K 大层和
https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/

第 335 场周赛 T2。

给你一棵二叉树的根节点 root 和一个正整数 k 。
树中的 层和 是指 同一层 上节点值的总和。
返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
提示：
树中的节点数为 n
2 <= n <= 10^5
1 <= Node.val <= 10^6
1 <= k <= n

层序遍历 + 排序
时间复杂度 O(nlogn)
 */