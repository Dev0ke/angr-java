public class SolutionP510 {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        // UT
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }
}
/*
$510. 二叉搜索树中的中序后继 II
https://leetcode.cn/problems/inorder-successor-in-bst-ii/

给定一棵二叉搜索树和其中的一个节点 node ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
一个节点 node 的中序后继是键值比 node.val 大所有的节点中键值最小的那个。
你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。节点 Node 定义如下：
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
提示：
树中节点的数目在范围 [1, 10^4] 内。
-10^5 <= Node.val <= 10^5
树中各结点的值均保证唯一。
进阶：你能否在不访问任何结点的值的情况下解决问题?

难度升级，不直接给出根节点
相似题目: $285. 二叉搜索树中的中序后继
https://leetcode.cn/problems/inorder-successor-in-bst/
 */