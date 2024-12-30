import java.util.LinkedList;
import java.util.Queue;

public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        // 注意由于需要 add null，所以不能用 ArrayDeque
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode x = q.remove();
            if (x == null) {
                flag = true;
                continue;
            }
            // 出现过 null 后不能再出现 非null
            if (flag) {
                return false;
            }
            q.add(x.left);
            q.add(x.right);
        }
        return true;
    }
}
/*
958. 二叉树的完全性检验
https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/

给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
提示：
树中节点数目在范围 [1, 100] 内
1 <= Node.val <= 1000

BFS 层序遍历。
时间复杂度 O(n)。
 */