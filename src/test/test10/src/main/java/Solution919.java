import java.util.ArrayDeque;
import java.util.Queue;

public class Solution919 {
    static class CBTInserter {
        private final Queue<TreeNode> queue;
        private final TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new ArrayDeque<>();
            queue.add(root);
            while (queue.element().left != null && queue.element().right != null) {
                TreeNode node = queue.remove();
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        public int insert(int v) {
            TreeNode parent = queue.element();
            TreeNode node = new TreeNode(v);
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
                queue.remove();
                queue.add(parent.left);
                queue.add(parent.right);
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
/*
919. 完全二叉树插入器
https://leetcode.cn/problems/complete-binary-tree-inserter/

第 105 场周赛 T3。

完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
实现 CBTInserter 类:
- CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
- CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
- CBTInserter.get_root() 将返回树的头节点。
提示：
树中节点数量范围为 [1, 1000]
0 <= Node.val <= 5000
root 是完全二叉树
0 <= val <= 5000 
每个测试用例最多调用 insert 和 get_root 操作 10^4 次

队列
 */