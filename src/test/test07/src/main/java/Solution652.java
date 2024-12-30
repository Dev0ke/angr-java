import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {
    private int id;
    private Map<String, Integer> serialUidMap;
    private Map<Integer, Integer> cntMap;
    private List<TreeNode> resList;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        id = 1;
        serialUidMap = new HashMap<>();
        cntMap = new HashMap<>();
        resList = new ArrayList<>();

        dfs(root);
        return resList;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 序列化
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        int uid = serialUidMap.computeIfAbsent(serial, key -> id++);
        cntMap.put(uid, cntMap.getOrDefault(uid, 0) + 1);
        if (cntMap.get(uid) == 2) {
            resList.add(root);
        }
        return uid;
    }
}
/*
652. 寻找重复的子树
https://leetcode.cn/problems/find-duplicate-subtrees/

给定一棵二叉树 root，返回所有重复的子树。
对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
提示：
树中的结点数在[1,10^4]范围内。
-200 <= Node.val <= 200

每个 根节点+左节点+右节点 映射到一个 uid.
HashMap 统计频次，若出现 2 次，则添加进结果集中。
时间复杂度 O(n)
 */