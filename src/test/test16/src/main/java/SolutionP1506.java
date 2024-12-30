import java.util.ArrayList;
import java.util.List;

public class SolutionP1506 {
    public Node findRoot(List<Node> tree) {
        int valueSum = 0;
        for (Node node : tree) {
            // 该值作为父节点添加
            valueSum += node.val;
            for (Node child : node.children) {
                // 该值将作为子节点扣除
                valueSum -= child.val;
            }
        }

        Node root = null;
        // 根节点的值是 valueSum
        for (Node node : tree) {
            if (node.val == valueSum) {
                root = node;
                break;
            }
        }
        return root;
    }

    // UT
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
$1506. 找到 N 叉树的根节点
https://leetcode.cn/problems/find-root-of-n-ary-tree/description/

给定一棵 N 叉树 的所有节点在一个数组  Node[] tree 中，树中每个节点都有 唯一的值 。
找到并返回 N 叉树的 根节点 。
自定义测试：
N 叉树的输入序列为其层序遍历序列，每组子节点用 null 分隔（见示例）。
上图中的 N 叉树的序列化描述为 [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14] 。
测试将以下列方式进行：
- 输入数据的形式为树的序列化描述。
- 驱动程序代码将根据序列化的输入数据构造树，并以任意顺序将每个 Node 对象放入一个数组中。
- 驱动程序代码将把数组传递给 findRoot ，你所编写的函数应该在数组中查找并返回根 Node 对象。
- 驱动程序代码将接受返回的 Node 对象并对其进行序列化。如果序列化的结果和输入数据 相同 ，则测试 通过 。
提示：
节点的总个数在 [1, 5*10^4] 之间。
每个节点都有唯一的值。
进阶：
你可以使用 O(1) 额外内存空间且 O(n) 时间复杂度的算法来找到该树的根节点吗？


 */