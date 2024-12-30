import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution501 {
    private Map<Integer, Integer> hashMap;

    public int[] findMode(TreeNode root) {
        hashMap = new HashMap<>();
        dfs(root);

        int max = 0;
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                resList.clear();
                resList.add(entry.getKey());
            } else if (entry.getValue() == max) {
                resList.add(entry.getKey());
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        hashMap.put(treeNode.val, hashMap.getOrDefault(treeNode.val, 0) + 1);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
/*
501. 二叉搜索树中的众数
https://leetcode.cn/problems/find-mode-in-binary-search-tree/

给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
- 结点左子树中所含节点的值 小于等于 当前节点的值
- 结点右子树中所含节点的值 大于等于 当前节点的值
- 左子树和右子树都是二叉搜索树
提示：
树中节点的数目在范围 [1, 10^4] 内
-10^5 <= Node.val <= 10^5
进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

HashMap 统计频次，得出众数。
 */