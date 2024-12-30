import java.util.ArrayList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return backtrack(1, n);
    }

    private List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> resList = new ArrayList<>();
        if (start > end) {
            resList.add(null);
            return resList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = backtrack(start, i - 1);
            List<TreeNode> rightList = backtrack(i + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    resList.add(root);
                }
            }
        }
        return resList;
    }
}
/*
95. 不同的二叉搜索树 II
https://leetcode.cn/problems/unique-binary-search-trees-ii/

给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
提示：
1 <= n <= 8

回溯
时间复杂度 O(nGn) Gn 为第 n 个卡特兰数
相似题目: 96. 不同的二叉搜索树
https://leetcode.cn/problems/unique-binary-search-trees/
 */