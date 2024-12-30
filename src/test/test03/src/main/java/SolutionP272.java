import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP272 {
    private double target;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        dfs(root);

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                resList.add(minHeap.remove());
                continue;
            }
            if (minHeap.isEmpty()) {
                resList.add(maxHeap.remove());
                continue;
            }
            if (target - maxHeap.peek() <= minHeap.peek() - target) {
                resList.add(maxHeap.remove());
            } else {
                resList.add(minHeap.remove());
            }
        }
        return resList;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val >= target) {
            minHeap.add(root.val);
        } else {
            maxHeap.add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
/*
$272. 最接近的二叉搜索树值 II
https://leetcode.cn/problems/closest-binary-search-tree-value-ii/

给定二叉搜索树的根 root 、一个目标值 target 和一个整数 k ，返回BST中最接近目标的 k 个值。你可以按 任意顺序 返回答案。
题目 保证 该二叉搜索树中只会存在一种 k 个值集合最接近 target
提示：
二叉树的节点总数为 n
1 <= k <= n <= 10^4
0 <= Node.val <= 10^9
-10^9 <= target <= 10^9
进阶：假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（ n = total nodes ）的时间复杂度内解决该问题呢？

双堆分别存放大于 target 和小于 target 的值，两两比较即可。
时间复杂度 O(n + klogn)
 */