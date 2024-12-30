public class SolutionP426 {
    private Node prefix;
    private Node suffix;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        suffix.right = prefix;
        prefix.left = suffix;
        return prefix;
    }

    private void dfs(Node root) {
        if (root != null) {
            dfs(root.left);
            if (suffix != null) {
                suffix.right = root;
                root.left = suffix;
            } else {
                prefix = root;
            }
            suffix = root;
            dfs(root.right);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
/*
$426. 将二叉搜索树转化为排序的双向链表
https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
提示：
-1000 <= Node.val <= 1000
Node.left.val < Node.val < Node.right.val
Node.val 的所有值都是独一无二的
0 <= Number of Nodes <= 2000

dfs
 */