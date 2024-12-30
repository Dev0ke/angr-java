public class Solution998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}
/*
998. 最大二叉树 II
https://leetcode.cn/problems/maximum-binary-tree-ii/

最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
给你最大树的根节点 root 和一个整数 val 。
就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
- 如果 a 为空，返回 null 。
- 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
- root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
- root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
- 返回 root 。
请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
返回 Construct(b) 。
提示：
树中节点数目在范围 [1, 100] 内
1 <= Node.val <= 100
树中的所有值 互不相同
1 <= val <= 100

相似题目: 654. 最大二叉树
https://leetcode.cn/problems/maximum-binary-tree/
 */