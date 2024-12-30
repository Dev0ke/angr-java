import java.util.ArrayList;
import java.util.List;

public class Solution987 {
    private List<int[]> nodeList;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodeList = new ArrayList<>();
        dfs(root, 0, 0);
        nodeList.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[2], o2[2]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        List<List<Integer>> resList = new ArrayList<>();
        int sz = 0;
        int preCol = Integer.MIN_VALUE;
        for (int[] node : nodeList) {
            int row = node[0], col = node[1], val = node[2];
            if (col != preCol) {
                preCol = col;
                resList.add(new ArrayList<>());
                sz++;
            }
            resList.get(sz - 1).add(val);
        }
        return resList;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        nodeList.add(new int[]{row, col, node.val});
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
/*
987. 二叉树的垂序遍历
https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/

给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
返回二叉树的 垂序遍历 序列。
提示：
树中结点数目总数在范围 [1, 1000] 内
0 <= Node.val <= 1000

跟 314 题相似，但多了个条件，要求位置相同的按值从小到大排序。
DFS + 自定义排序
相似题目: $314. 二叉树的垂直遍历
https://leetcode.cn/problems/binary-tree-vertical-order-traversal/
 */