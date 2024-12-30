import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1932 {
    private Map<Integer, TreeNode> candidates;
    private int pre;

    public TreeNode canMerge(List<TreeNode> trees) {
        // 存储所有叶节点值的哈希集合
        Set<Integer> leaves = new HashSet<>();
        // 存储 (根节点值, 树) 键值对的哈希映射
        candidates = new HashMap<>();
        for (TreeNode tree : trees) {
            if (tree.left != null) leaves.add(tree.left.val);
            if (tree.right != null) leaves.add(tree.right.val);
            candidates.put(tree.val, tree);
        }

        // 存储中序遍历上一个遍历到的值，便于检查严格单调性
        pre = 0;
        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                candidates.remove(tree.val);
                // 如果中序遍历有严格单调性，并且所有树的根节点都被遍历到，说明可以构造二叉搜索树
                return dfs(tree) && candidates.isEmpty() ? tree : null;
            }
        }
        return null;
    }

    // 中序遍历，返回值表示是否有严格单调性
    private boolean dfs(TreeNode tree) {
        if (tree == null) return true;
        // 如果遍历到叶节点，并且存在可以合并的树，那么就进行合并
        if (tree.left == null && tree.right == null && candidates.containsKey(tree.val)) {
            tree.left = candidates.get(tree.val).left;
            tree.right = candidates.get(tree.val).right;
            // 合并完成后，将树从哈希映射中移除，以便于在遍历结束后判断是否所有树都被遍历过
            candidates.remove(tree.val);
        }
        if (!dfs(tree.left)) return false;
        if (tree.val <= pre) return false;
        pre = tree.val;
        return dfs(tree.right);
    }
}
/*
1932. 合并多棵二叉搜索树
https://leetcode.cn/problems/merge-bsts-to-create-single-bst/

第 249 场周赛 T4。

给你 n 个 二叉搜索树的根节点 ，存储在数组 trees 中（下标从 0 开始），对应 n 棵不同的二叉搜索树。trees 中的每棵二叉搜索树 最多有 3 个节点 ，且不存在值相同的两个根节点。在一步操作中，将会完成下述步骤：
- 选择两个 不同的 下标 i 和 j ，要求满足在 trees[i] 中的某个 叶节点 的值等于 trees[j] 的 根节点的值 。
- 用 trees[j] 替换 trees[i] 中的那个叶节点。
- 从 trees 中移除 trees[j] 。
如果在执行 n - 1 次操作后，能形成一棵有效的二叉搜索树，则返回结果二叉树的 根节点 ；如果无法构造一棵有效的二叉搜索树，返回 null 。
二叉搜索树是一种二叉树，且树中每个节点均满足下述属性：
- 任意节点的左子树中的值都 严格小于 此节点的值。
- 任意节点的右子树中的值都 严格大于 此节点的值。
- 叶节点是不含子节点的节点。
提示：
n == trees.length
1 <= n <= 5 * 10^4
每棵树中节点数目在范围 [1, 3] 内。
输入数据的每个节点可能有子节点但不存在子节点的子节点
trees 中不存在两棵树根节点值相同的情况。
输入中的所有树都是 有效的二叉树搜索树 。
1 <= TreeNode.val <= 5 * 10^4.

DFS 中序遍历
时间复杂度 O(n)
空间复杂度 O(n)
 */