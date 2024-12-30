import java.util.ArrayList;
import java.util.List;

public class Solution1305 {
    private List<Integer> ans;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        ans.sort(null);
        return ans;
    }

    private void dfs(TreeNode x) {
        if (x == null) return;
        dfs(x.left);
        ans.add(x.val);
        dfs(x.right);
    }
}
/*
1305. 两棵二叉搜索树中的所有元素
https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/description/

给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
提示：
每棵树的节点数在 [0, 5000] 范围内
-10^5 <= Node.val <= 10^5

正解应该是 中序遍历 + 合并有序数组。库函数排序也未尝不可。
时间复杂度 O(n+m)。或 O(n+m * log(n+m))。
 */