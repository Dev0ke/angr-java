import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP1522 {
    private int max = 1;

    public int diameter(Node root) {
        max = 1;
        dfs(root);
        return max - 1;
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Node child : root.children) {
            int cnt = dfs(child);
            maxHeap.add(cnt);
        }
        int top1 = maxHeap.isEmpty() ? 0 : maxHeap.remove();
        int top2 = maxHeap.isEmpty() ? 0 : maxHeap.remove();
        max = Math.max(max, top1 + top2 + 1);
        return Math.max(top1, top2) + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
/*
$1522. N 叉树的直径
https://leetcode.cn/problems/diameter-of-n-ary-tree/

给定一棵 N 叉树的根节点 root ，计算这棵树的直径长度。
N 叉树的直径指的是树中任意两个节点间路径中 最长 路径的长度。这条路径可能经过根节点，也可能不经过根节点。
（N 叉树的输入序列以层序遍历的形式给出，每组子节点用 null 分隔）
提示：
N 叉树的深度小于或等于 1000 。
节点的总个数在 [0, 10^4] 间。

dfs
相似题目: 543. 二叉树的直径
https://leetcode.cn/problems/diameter-of-binary-tree/
 */