import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDeg = new int[n];
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                ++inDeg[leftChild[i]];
            }
            if (rightChild[i] != -1) {
                ++inDeg[rightChild[i]];
            }
        }
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                root = i;
                break;
            }
        }
        if (root == -1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        seen.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            int u = q.remove();
            if (leftChild[u] != -1) {
                if (seen.contains(leftChild[u])) {
                    return false;
                }
                seen.add(leftChild[u]);
                q.add(leftChild[u]);
            }
            if (rightChild[u] != -1) {
                if (seen.contains(rightChild[u])) {
                    return false;
                }
                seen.add(rightChild[u]);
                q.add(rightChild[u]);
            }
        }

        return seen.size() == n;
    }
}
/*
1361. 验证二叉树
https://leetcode.cn/problems/validate-binary-tree-nodes/description/

二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
注意：节点没有值，本问题中仅仅使用节点编号。
提示：
n == leftChild.length == rightChild.length
1 <= n <= 10^4
-1 <= leftChild[i], rightChild[i] <= n - 1

连通性判定。
时间复杂度 O(n)。
官解：本题的标准程序有误，并且测试数据非常弱，这会导致一些错误的算法可以通过所有的数据。
 */