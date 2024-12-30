import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                // 连接
                if (i != size - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
/*
117. 填充每个节点的下一个右侧节点指针 II
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/

给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
提示：
树中的节点数小于 6000
-100 <= node.val <= 100

层序遍历。
同: 116. 填充每个节点的下一个右侧节点指针
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */