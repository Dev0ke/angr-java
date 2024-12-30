import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                curLevel.add(cur.val);
                if (cur.children != null) {
                    queue.addAll(cur.children);
                }
            }
            resList.add(curLevel);
        }
        return resList;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
/*
429. N 叉树的层序遍历
https://leetcode.cn/problems/n-ary-tree-level-order-traversal/

给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
提示：
树的高度不会超过 1000
树的节点总数在 [0, 10^4] 之间

相似题目: 102. 二叉树的层序遍历
https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */