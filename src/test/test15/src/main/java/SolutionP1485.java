import java.util.HashMap;
import java.util.Map;

public class SolutionP1485 {
    Map<Node, NodeCopy> copyMap = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        if (!copyMap.containsKey(root)) {
            NodeCopy copyRoot = new NodeCopy(root.val);
            copyMap.put(root, copyRoot);
            copyRoot.left = copyRandomBinaryTree(root.left);
            copyRoot.right = copyRandomBinaryTree(root.right);
            copyRoot.random = copyRandomBinaryTree(root.random);
        }
        return copyMap.get(root);
    }

    // UT
    static class NodeCopy extends Node {
        public NodeCopy(int val) {
            super(val);
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }
}
/*
$1485. 克隆含随机指针的二叉树
https://leetcode.cn/problems/clone-binary-tree-with-random-pointer/description/

给你一个二叉树，树中每个节点都含有一个附加的随机指针，该指针可以指向树中的任何节点或者指向空（null）。
请返回该树的 深拷贝 。
该树的输入/输出形式与普通二叉树相同，每个节点都用 [val, random_index] 表示：
- val：表示 Node.val 的整数
- random_index：随机指针指向的节点（在输入的树数组中）的下标；如果未指向任何节点，则为 null 。
该树以 Node 类的形式给出，而你需要以 NodeCopy 类的形式返回克隆得到的树。NodeCopy 类和Node 类定义一致。
提示：
tree 中节点数目范围是 [0, 1000]
每个节点的值的范围是 [1, 10^6]


 */