import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionP314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(0);
        Map<Integer, List<Integer>> posListMap = new HashMap<>();
        // 最左侧的 pos
        int leftPos = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            int pos = queue2.remove();
            posListMap.computeIfAbsent(pos, key -> new ArrayList<>()).add(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
                queue2.add(pos - 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                queue2.add(pos + 1);
            }

            leftPos = Math.min(leftPos, pos);
        }

        for (int i = leftPos; i < leftPos + posListMap.size(); i++) {
            resList.add(posListMap.get(i));
        }
        return resList;
    }
}
/*
$314. 二叉树的垂直遍历
https://leetcode.cn/problems/binary-tree-vertical-order-traversal/

给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
如果两个结点在同一行和列，那么顺序则为 从左到右。
提示：
树中结点的数目在范围 [0, 100] 内
-100 <= Node.val <= 100

层次遍历，记录垂直坐标。
 */