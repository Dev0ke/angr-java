import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution508 {
    private Map<Integer, Integer> cntMap;

    public int[] findFrequentTreeSum(TreeNode root) {
        cntMap = new HashMap<>();
        dfs(root);

        int maxCnt = 0;
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                resList.clear();
                resList.add(entry.getKey());
            } else if (entry.getValue() == maxCnt) {
                resList.add(entry.getKey());
            }
        }

        return resList.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        cntMap.put(sum, cntMap.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
/*
508. 出现次数最多的子树元素和
https://leetcode.cn/problems/most-frequent-subtree-sum/

给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
提示:
节点数在 [1, 10^4] 范围内
-10^5 <= Node.val <= 10^5

DFS + HashMap 统计频次。
 */