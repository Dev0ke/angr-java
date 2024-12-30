import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (cur.children != null) {
                    queue.addAll(cur.children);
                }
            }
        }
        return maxDepth;
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
559. N 叉树的最大深度
https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/

给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
提示：
树的深度不会超过 1000 。
树的节点数目位于 [0, 10^4] 之间。

层序遍历。
相似题目: 104. 二叉树的最大深度
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */