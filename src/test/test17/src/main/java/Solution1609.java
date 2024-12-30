import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        // 二叉树 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (level % 2 == 1) {
                if (!checkOddLevel(curLevel)) {
                    return false;
                }

            } else {
                if (!checkEvenLevel(curLevel)) {
                    return false;
                }
            }
            level++;
        }
        return true;
    }

    // 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
    private boolean checkEvenLevel(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) % 2 == 0) {
                return false;
            }
            if (i > 0) {
                if (list.get(i) <= list.get(i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
    private boolean checkOddLevel(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) % 2 == 1) {
                return false;
            }
            if (i > 0) {
                if (list.get(i) >= list.get(i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
1609. 奇偶树
https://leetcode.cn/problems/even-odd-tree/

第 209 场周赛 T2。

如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
- 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
- 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
- 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
提示：
树中节点数在范围 [1, 10^5] 内
1 <= Node.val <= 10^6

二叉树层序遍历。
相似题目: 102. 二叉树的层序遍历
https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */