import java.util.HashSet;
import java.util.Set;

public class Solution1261 {
    static class FindElements {
        private final Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            set.add(0);
            dfs(root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void dfs(TreeNode node) {
            if (node.left != null) {
                int val = node.val * 2 + 1;
                node.left.val = val;
                set.add(val);
                dfs(node.left);
            }
            if (node.right != null) {
                int val = node.val * 2 + 2;
                node.right.val = val;
                set.add(val);
                dfs(node.right);
            }
        }
    }
}
/*
1261. 在受污染的二叉树中查找元素
https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/

给出一个满足下述规则的二叉树：
1. root.val == 0
2. 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
3. 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
请你先还原二叉树，然后实现 FindElements 类：
- FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
- bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
提示：
TreeNode.val == -1
二叉树的高度不超过 20
节点的总数在 [1, 10^4] 之间
调用 find() 的总次数在 [1, 10^4] 之间
0 <= target <= 10^6

先还原存放到 hashset 中，再判断
时间复杂度 O(n)
空间复杂度 O(n)
 */