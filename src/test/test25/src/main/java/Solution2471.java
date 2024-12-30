import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2471 {
    public int minimumOperations(TreeNode root) {
        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> a = new ArrayList<>();
            List<Integer> sorted = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 上下文已保证 cur 不为 null
                TreeNode cur = queue.remove();
                a.add(cur.val);
                sorted.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            Collections.sort(sorted);
            Map<Integer, Integer> idxMap = new HashMap<>();
            int sz = sorted.size();
            for (int i = 0; i < sz; i++) {
                idxMap.put(sorted.get(i), i);
            }
            for (int i = 0; i < sz; i++) {
                while (i != idxMap.get(a.get(i))) {
                    res++;
                    Collections.swap(a, i, idxMap.get(a.get(i)));
                }
            }
        }
        return res;
    }
}
/*
2471. 逐层排序二叉树所需的最少操作数目
https://leetcode.cn/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/

第 319 场周赛 T3。

给你一个 值互不相同 的二叉树的根节点 root 。
在一步操作中，你可以选择 同一层 上任意两个节点，交换这两个节点的值。
返回每一层按 严格递增顺序 排序所需的最少操作数目。
节点的 层数 是该节点和根节点之间的路径的边数。
提示：
树中节点的数目在范围 [1, 10^5] 。
1 <= Node.val <= 10^5
树中的所有值 互不相同 。

问题等价于：无序数组交换任意两个元素 最少交换次数
https://blog.csdn.net/qq_50332374/article/details/118612496
 */