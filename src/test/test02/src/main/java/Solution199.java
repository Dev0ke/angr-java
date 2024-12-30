import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 当前层元素
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                levelList.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            resList.add(levelList.get(levelList.size() - 1));
        }
        return resList;
    }
}
/*
199. 二叉树的右视图
https://leetcode.cn/problems/binary-tree-right-side-view/

给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
提示:
二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100

二叉树“按层”。两个队列实现二叉树广搜
相似题目: 513. 找树左下角的值
https://leetcode.cn/problems/find-bottom-left-tree-value/
515. 在每个树行中找最大值
https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */