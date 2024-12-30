public class Solution968 {
    private int res = 0;

    public int minCameraCover(TreeNode root) {
        // 如果父节点是无覆盖状态，那么需要在父节点添加一台摄像机
        return dfs(root) == 0 ? res + 1 : res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            // 节点有覆盖
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 后序遍历
        // 0 表示无覆盖，1 表示有相机，2 表示有覆盖，左右节点可以组成9种状态 (00,01,02,10,11,12,20,21,22)
        // 只要有一个无覆盖，父节点就需要相机来覆盖这个子节点 00,01,10,20,02
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        // 子节点其中只要有一个有相机，那么父节点就会是有覆盖的状态 11,21,12
        if (left == 1 || right == 1) {
            return 2;
        }
        // 还有一个就是 22，两个子节点都是有覆盖的状态，父节点可以没有相机，可以借助它自己的父节点
        return 0;
    }
}
/*
968. 监控二叉树
https://leetcode.cn/problems/binary-tree-cameras/

第 117 场周赛 T4。

给定一个二叉树，我们在树的节点上安装摄像头。
节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
计算监控树的所有节点所需的最小摄像头数量。
提示：
给定树的节点数的范围是 [1, 1000]。
每个节点的值都是 0。

贪心，非动态规划。
考虑三种情况：
0：该节点无覆盖
1：本节点有摄像头
2：本节点有覆盖
 */