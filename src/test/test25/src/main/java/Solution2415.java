import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelVal = new ArrayList<>();
            List<TreeNode> curLevelNode = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                curLevelVal.add(cur.val);
                curLevelNode.add(cur);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            // 奇数层节点重新赋值
            if (level % 2 == 1) {
                Collections.reverse(curLevelVal);
                for (int i = 0; i < curLevelVal.size(); i++) {
                    curLevelNode.get(i).val = curLevelVal.get(i);
                }
            }
            level++;
        }
        return root;
    }
}
/*
2415. 反转二叉树的奇数层
https://leetcode.cn/problems/reverse-odd-levels-of-binary-tree/

第 311 场周赛 T3。

给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
- 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
反转后，返回树的根节点。
完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
节点的 层数 等于该节点到根节点之间的边数。
提示：
树中的节点数目在范围 [1, 2^14] 内
0 <= Node.val <= 10^5
root 是一棵 完美 二叉树

二叉树层序遍历。对奇数层节点重新赋值即可。
时间复杂度 O(n)
相似题目: 102. 二叉树的层序遍历
https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */