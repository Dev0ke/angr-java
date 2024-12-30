public class SolutionP1666 {
    public Node flipBinaryTree(Node root, Node leaf) {
        flip(leaf);
        return leaf;
    }

    private void flip(Node cur) {
        if (cur == null) return;
        Node parent = cur.parent;
        // 断开当前节点和父节点的联系
        if (parent != null) {
            if (cur == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            cur.parent = null;
        }
        // 递归地去全部“打断”当前节点和父节点的联系
        flip(parent);
        // flip转换父子关系，重新组装
        if (parent != null) {
            if (cur.left != null) { // 如果有左孩子需要保留，移动到右孩子的位置上保存
                cur.right = cur.left;
            }
            cur.left = parent;
            parent.parent = cur;
        }
    }

    // UT
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
/*
$1666. 改变二叉树的根节点
https://leetcode.cn/problems/change-the-root-of-a-binary-tree/description/

给定一棵二叉树的根节点 root 和一个叶节点 leaf ，更改二叉树，使得 leaf 为新的根节点。
你可以按照下列步骤修改从 leaf 到 root 的路径中除 root 外的每个节点 cur ：
1.如果 cur 有左子节点，则该子节点变为 cur 的右子节点。注意我们保证 cur 至多有一个子节点。
2.cur 的原父节点变为 cur 的左子节点。
返回修改后新树的根节点。
注意：确保你的答案在操作后正确地设定了 Node.parent （父节点）指针，否则会被判为错误答案。
提示:
树中节点的个数在范围 [2, 100] 内。
-10^9 <= Node.val <= 10^9
所有的 Node.val 都是唯一的。
leaf 存在于树中。

首先自底向上地从叶子结点开始打破子节点和父节点的双向指针联系。然后如果按照 flip 后得到结果树的视角去看再自底向上地重新构建子节点和父节点的双向指针关系。
https://leetcode.cn/problems/change-the-root-of-a-binary-tree/solutions/842992/cjie-fa-rong-yi-li-jie-by-thinking-i-zqmu/
 */