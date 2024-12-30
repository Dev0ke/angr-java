import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution894 {
    private Map<Integer, List<TreeNode>> memo;

    public List<TreeNode> allPossibleFBT(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> resList = new ArrayList<>();
        if (n == 1) {
            resList.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int x = 0; x < n; x++) {
                int y = n - 1 - x;
                for (TreeNode left : allPossibleFBT(x)) {
                    for (TreeNode right : allPossibleFBT(y)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        resList.add(root);
                    }
                }
            }
        }
        memo.put(n, resList);
        return resList;
    }
}
/*
894. 所有可能的真二叉树
https://leetcode.cn/problems/all-possible-full-binary-trees/

给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
提示：
1 <= n <= 20

递归。
第 k 个卡特兰数（Catalan Number）
时间复杂度 O(2^n)
空间复杂度 O(2^n)
 */