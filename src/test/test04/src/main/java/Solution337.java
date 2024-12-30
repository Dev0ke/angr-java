public class Solution337 {
    public int rob(TreeNode root) {
        // dp[0] 表示 root 被选取时的最大值；dp[1] 表示 root 不被选取时的最大值
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int select = root.val + left[1] + right[1];
        int notSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{select, notSelect};
    }
}
/*
337. 打家劫舍 III
https://leetcode.cn/problems/house-robber-iii/

小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
提示：
树的节点数在 [1, 10^4] 范围内
0 <= Node.val <= 10^4

树形 DP 维护两个值（选 或 不选）。
时间复杂度 O(n)。
相似题目: $2378. 选择边来最大化树的得分
https://leetcode.cn/problems/choose-edges-to-maximize-score-in-a-tree/description/
 */