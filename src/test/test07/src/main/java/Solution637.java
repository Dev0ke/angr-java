import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int cnt = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                // 统计和 和 个数
                sum += cur.val;
                cnt++;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            resList.add(sum / cnt);
        }
        return resList;
    }
}
/*
637. 二叉树的层平均值
https://leetcode.cn/problems/average-of-levels-in-binary-tree/

给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。
示例 1：
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
提示：
树中节点数量在 [1, 10^4] 范围内
-2^31 <= Node.val <= 2^31 - 1

二叉树层序遍历。
 */