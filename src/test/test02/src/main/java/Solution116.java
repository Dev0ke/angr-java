import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {
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
116. 填充每个节点的下一个右侧节点指针
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
提示：
树中节点的数量在 [0, 2^12 - 1] 范围内
-1000 <= node.val <= 1000

层次遍历。
同: 117. 填充每个节点的下一个右侧节点指针 II
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 */