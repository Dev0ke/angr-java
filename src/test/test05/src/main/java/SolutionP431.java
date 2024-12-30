import java.util.ArrayList;
import java.util.List;

public class SolutionP431 {
    static class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }

            TreeNode treeNode = new TreeNode(root.val);
            if (root.children == null || root.children.size() == 0) {
                return treeNode;
            }
            TreeNode child = encode(root.children.get(0));
            treeNode.left = child;
            for (int i = 1; i < root.children.size(); i++) {
                child.right = encode(root.children.get(i));
                child = child.right;
            }
            return treeNode;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }

            Node node = new Node(root.val, new ArrayList<>());
            if (root.left == null) {
                return node;
            }
            TreeNode left = root.left;
            while (left != null) {
                node.children.add(decode(left));
                left = left.right;
            }
            return node;
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
$431. 将 N 叉树编码为二叉树
https://leetcode.cn/problems/encode-n-ary-tree-to-binary-tree/

设计一个算法，可以将 N 叉树编码为二叉树，并能将该二叉树解码为原 N 叉树。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。
类似地，一个二叉树是指每个节点都有不超过 2 个孩子节点的有根树。你的编码 / 解码的算法的实现没有限制，你只需要保证一个 N 叉树可以编码为二叉树且该二叉树可以解码回原始 N 叉树即可。
例如，你可以将下面的 3-叉 树以该种方式编码：
注意，上面的方法仅仅是一个例子，可能可行也可能不可行。你没有必要遵循这种形式转化，你可以自己创造和实现不同的方法。
注意：
N 的范围在 [1, 1000]
不要使用类成员 / 全局变量 / 静态变量来存储状态。你的编码和解码算法应是无状态的。

递归。
 */