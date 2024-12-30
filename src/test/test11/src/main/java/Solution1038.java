import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1038 {
    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
/*
1038. 把二叉搜索树转换为累加树
https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/

第 135 场周赛 T2。

给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
提醒一下，二叉搜索树满足下列约束条件：
- 节点的左子树仅包含键 小于 节点键的节点。
- 节点的右子树仅包含键 大于 节点键的节点。
- 左右子树也必须是二叉搜索树。
提示：
树中的节点数在 [1, 100] 范围内。
0 <= Node.val <= 100
树中的所有值均 不重复 。

同: 538. 把二叉搜索树转换为累加树
https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */