import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        preorder(root, resList);
        return resList;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 前序遍历
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, list);
            }
        }
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
589. N 叉树的前序遍历
https://leetcode.cn/problems/n-ary-tree-preorder-traversal/

给定一个 N 叉树，返回其节点值的 前序遍历 。
N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
提示：
节点总数在范围 [0, 10^4]内
0 <= Node.val <= 10^4
n 叉树的高度小于或等于 1000
进阶：递归法很简单，你可以使用迭代法完成此题吗?

DFS.
相似题目: 144. 二叉树的前序遍历
https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */