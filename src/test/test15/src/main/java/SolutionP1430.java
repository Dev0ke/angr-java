public class SolutionP1430 {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode root, int[] arr, int st) {
        int arrLen = arr.length - st;
        if (root == null || arrLen == 0 || root.val != arr[st]) return false;
        if (root.left == root.right) return arrLen == 1;
        return dfs(root.left, arr, st + 1) || dfs(root.right, arr, st + 1);
    }
}
/*
$1430. 判断给定的序列是否是二叉树从根到叶的路径
https://leetcode.cn/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/description/

给定一个二叉树，我们称从根节点到任意叶节点的任意路径中的节点值所构成的序列为该二叉树的一个 “有效序列” 。检查一个给定的序列是否是给定二叉树的一个 “有效序列” 。
我们以整数数组 arr 的形式给出这个序列。从根节点到任意叶节点的任意路径中的节点值所构成的序列都是这个二叉树的 “有效序列” 。
提示：
1 <= arr.length <= 5000
0 <= arr[i] <= 9
每个节点的值的取值范围是 [0 - 9]

DFS。
 */