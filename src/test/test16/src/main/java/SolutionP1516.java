import java.util.ArrayList;
import java.util.List;

public class SolutionP1516 {
    // p 和 q 的父节点
    Node pp;
    Node qp;
    // q 是否是 p 的子树的特殊情况
    boolean qIsPChildren = false;

    public Node moveSubTree(Node root, Node p, Node q) {
        // 采用一个 dummy 节点来解决边缘情况，树解法的常用套路
        Node dummy = new Node(0);
        dummy.children.add(root);
        dfs(root, dummy, p, q, false);

        // 按照讨论三种情况分别处理
        if (pp == q) {
            // do nothing
        } else if (qIsPChildren) {
            qp.children.remove(q);
            for (int i = 0; i < pp.children.size(); ++i) {
                if (pp.children.get(i) == p) {
                    pp.children.set(i, q);
                    break;
                }
            }
            q.children.add(p);
        } else {
            pp.children.remove(p);
            q.children.add(p);
        }

        return dummy.children.get(0);
    }

    void dfs(Node curr, Node parent, Node p, Node q, boolean isUnderP) {
        if (curr == p) {
            pp = parent;
            isUnderP = true;
        } else if (curr == q) {
            if (isUnderP) {
                qIsPChildren = true;
            }
            qp = parent;
        }
        for (Node child : curr.children) {
            dfs(child, curr, p, q, isUnderP);
        }
    }

    // UT
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
/*
$1516. 移动 N 叉树的子树
https://leetcode.cn/problems/move-sub-tree-of-n-ary-tree/description/

给定一棵没有重复值的 N 叉树 的根节点 root ，以及其中的两个节点 p 和 q。
移动节点 p 及其子树，使节点 p 成为节点 q 的直接子节点。如果 p 已经是 q 的直接子节点，则请勿改动任何节点。节点 p 必须是节点 q 的子节点列表的最后一项。
返回改动后的树的根节点。
节点 p 和 q 可能是下列三种情况之一：
1.节点 q 在节点 p 的子树中。
2.节点 p 在节点 q 的子树中。
3.节点 p 不在节点 q 的子树中，且节点 q 也不在节点 p 的子树中。
在第 2 种和第 3 种情况中，你只需要移动 p （及其子树），使 p 成为 q 的子节点。但是在第 1 种情况中，树的节点可能会断连，因此你还需要重新连接这些节点。请在解题前仔细阅读示例。
N 叉树的输入序列以层序遍历的形式给出，每组子节点用 null 分隔（见示例）。
例如，上面的树会被序列化为 [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]。
提示:
节点的总数在 [2, 1000] 间。
每个节点都有 唯一 的值。
p != null
q != null
p 和 q 是两个不同的节点（即 p != q ）。


 */