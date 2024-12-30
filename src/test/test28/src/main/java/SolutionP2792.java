import java.util.ArrayList;
import java.util.List;

public class SolutionP2792 {
    private int k, ans;

    public int countGreatEnoughNodes(TreeNode root, int k) {
        this.k = k;
        ans = 0;
        dfs(root);
        return ans;
    }

    private List<Integer> dfs(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        lis.addAll(dfs(node.left));
        lis.addAll(dfs(node.right));
        lis.add(node.val);
        lis.sort(null);
        if (lis.size() >= k && lis.get(k - 1) < node.val) ans++;
        return lis.size() > k ? lis.subList(0, k) : lis;
    }
}
/*
$2792. 计算足够大的节点数
https://leetcode.cn/problems/count-nodes-that-are-great-enough/description/

给定一棵二叉树的根节点 root 和一个整数 k 。如果一个节点满足以下条件，则称其为 足够大 ：
- 它的子树中 至少 有 k 个节点。
- 它的值 大于 其子树中 至少 k 个节点的值。
返回足够大的节点数。
如果 u == v 或者 v 是 u 的祖先，则节点 u 在节点 v 的 子树 中。
提示：
树中的节点数在范围 [1, 10^4] 内。
1 <= Node.val <= 10^4
1 <= k <= 10

DFS+合并有序数组。
 */