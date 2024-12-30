public class SolutionP1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p;
        Node p2 = q;
        while (p1 != p2) {
            p1 = (p1 != null) ? p1.parent : q;
            p2 = (p2 != null) ? p2.parent : p;
        }
        return p1;
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
    }
}
/*
$1650. 二叉树的最近公共祖先 III
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iii/

给定一棵二叉树中的两个节点 p 和 q，返回它们的最近公共祖先节点（LCA）。
每个节点都包含其父节点的引用（指针）。Node 的定义如下：
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点
（我们允许一个节点为自身的一个后代节点）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
提示:
树中节点个数的范围是 [2, 10^5]。
-10^9 <= Node.val <= 10^9
所有的 Node.val 都是互不相同的。
p != q
p 和 q 存在于树中。

双指针
相似题目: 160. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */