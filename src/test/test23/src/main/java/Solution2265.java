import java.util.LinkedList;
import java.util.Queue;

public class Solution2265 {
    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans += bfs(root);

        dfs(root.left);
        dfs(root.right);
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                sum += cur.val;
                cnt += 1;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return (sum / cnt == root.val) ? 1 : 0;
    }
}
/*
2265. 统计值等于子树平均值的节点数
https://leetcode.cn/problems/count-nodes-equal-to-average-of-subtree/

第 292 场周赛 T2。

给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
注意：
- n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
- root 的 子树 由 root 和它的所有后代组成。
提示：
树中节点数目在范围 [1, 1000] 内
0 <= Node.val <= 1000

dfs 遍历每个节点
bfs 统计每个点是否符合要求
时间复杂度 O(n^2)
 */