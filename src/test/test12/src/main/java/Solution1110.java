import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1110 {
    private Set<Integer> toDelete;
    private List<TreeNode> resList;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelete = new HashSet<>();
        for (int x : to_delete) {
            toDelete.add(x);
        }
        resList = new ArrayList<>();

        dfs(root, false);
        return resList;
    }

    private boolean dfs(TreeNode node, boolean faExist) {
        if (node == null) {
            return false;
        }

        boolean del = toDelete.contains(node.val);
        if (dfs(node.left, !del)) {
            node.left = null;
        }
        if (dfs(node.right, !del)) {
            node.right = null;
        }
        if (!del && !faExist) {
            resList.add(node);
        }
        return del;
    }
}
/*
1110. 删点成林
https://leetcode.cn/problems/delete-nodes-and-return-forest/

给出二叉树的根节点 root，树上每个节点都有一个不同的值。
如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
返回森林中的每棵树。你可以按任意顺序组织答案。
提示：
树中的节点数最大为 1000。
每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
to_delete.length <= 1000
to_delete 包含一些从 1 到 1000、各不相同的值。

后序遍历
时间复杂度 O(n)
 */