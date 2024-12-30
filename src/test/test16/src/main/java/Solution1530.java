public class Solution1530 {
    private int distance, ans;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        ans = 0;
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[distance];
        }

        int[] left = dfs(root.left);
        if (root.left == null && root.right == null) {
            left[0] = 1;
            return left;
        }

        int[] right = dfs(root.right);
        for (int i = 0, ls = 0; i < distance - 1; i++) {
            ls += left[i];
            ans += ls * right[distance - 2 - i];
        }

        for (int i = distance - 1; i > 0; i--) {
            left[i] = left[i - 1] + right[i - 1];
        }
        left[0] = 0;
        return left;
    }
}
/*
1530. 好叶子节点对的数量
https://leetcode.cn/problems/number-of-good-leaf-nodes-pairs/

给你二叉树的根节点 root 和一个整数 distance 。
如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
返回树中 好叶子节点对的数量 。
提示：
tree 的节点数在 [1, 2^10] 范围内。
每个节点的值都在 [1, 100] 之间。
1 <= distance <= 10

递归。
时间复杂度 O(n * distance^2)
空间复杂度 O(H * distance)
 */