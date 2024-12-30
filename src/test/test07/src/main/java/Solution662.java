import java.util.HashMap;
import java.util.Map;

public class Solution662 {
    private int max;
    private Map<Integer, Integer> leftMap;

    public int widthOfBinaryTree(TreeNode root) {
        max = 0;
        leftMap = new HashMap<>();
        dfs(root, 0, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        leftMap.putIfAbsent(depth, pos);
        max = Math.max(max, pos - leftMap.get(depth) + 1);
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }
}
/*
662. 二叉树最大宽度
https://leetcode.cn/problems/maximum-width-of-binary-tree/

给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
树的 最大宽度 是所有层中最大的 宽度 。
每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
题目数据保证答案将会在  32 位 带符号整数范围内。
提示：
树中节点的数目范围是 [1, 3000]
-100 <= Node.val <= 100

宽 = 层最右 - 层最左 + 1
 */