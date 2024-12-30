import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (hashSet.contains(k - cur.val)) {
                return true;
            }
            hashSet.add(cur.val);
            cur = cur.right;
        }
        return false;
    }
}
/*
653. 两数之和 IV - 输入 BST
https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/

给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
提示:
二叉树的节点个数的范围是  [1, 10^4].
-10^4 <= Node.val <= 10^4
root 为二叉搜索树
-10^5 <= k <= 10^5

“树版” 两数之和
哈希 空间复杂度 O(n)
 */