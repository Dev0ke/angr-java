public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = dfs(nums, left, maxIdx - 1);
        root.right = dfs(nums, maxIdx + 1, right);
        return root;
    }
}
/*
654. 最大二叉树
https://leetcode.cn/problems/maximum-binary-tree/

给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
1.创建一个根节点，其值为 nums 中的最大值。
2.递归地在最大值 左边 的 子数组前缀上 构建左子树。
3.递归地在最大值 右边 的 子数组后缀上 构建右子树。
返回 nums 构建的 最大二叉树 。
提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
nums 中的所有整数 互不相同

递归
相似题目: 998. 最大二叉树 II
https://leetcode.cn/problems/maximum-binary-tree-ii/
 */