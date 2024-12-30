import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SolutionP2764 {
    public boolean isPreorder(List<List<Integer>> nodes) {
        if (nodes.get(0).get(1) != -1) return false;
        int n = nodes.size();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(nodes.get(0).get(0));
        for (int i = 1; i < n; i++) {
            int id = nodes.get(i).get(0), parentId = nodes.get(i).get(1);
            while (!st.isEmpty() && st.peek() != parentId) {
                st.pop();
            }
            if (st.isEmpty()) return false;
            st.push(id);
        }
        return true;
    }
}
/*
$2764. 数组是否表示某二叉树的前序遍历
https://leetcode.cn/problems/is-array-a-preorder-of-some-binary-tree/description/

给定一个以 0 为起始索引的整数 二维数组 nodes ，你的任务是确定给定的数组是否表示某个 二叉 树的 前序 遍历。
对于每个索引 i ，nodes[i] = [id, parentId] ，其中 id 是索引 i 处节点的 id，parentId 是其在树中的父节点 id（如果该节点没有父节点，则 parentId = -1 ）。
如果给定的数组表示某个树的前序遍历，则返回 true ，否则返回 false 。
注意：树的 前序 遍历是一种递归的遍历方式，它首先访问当前节点，然后对左子节点进行前序遍历，最后对右子节点进行前序遍历。
提示：
1 <= nodes.length <= 10^5
nodes[i].length == 2
0 <= nodes[i][0] <= 10^5
-1 <= nodes[i][1] <= 10^5
生成的输入保证 nodes 可以组成二叉树。

当栈不为空且栈顶元素不等于 parent 时，将栈顶元素出栈，直到栈为空或栈顶元素等于 parent。
如果栈为空，则已经遍历过的结点中不存在当前结点的父结点，因此数组 nodes 不表示一个二叉树的前序遍历，返回 false。
如果栈不为空且栈顶元素等于 parent，则栈顶元素为当前结点的父结点值，将 child 入栈。
https://leetcode.cn/problems/is-array-a-preorder-of-some-binary-tree/solutions/2612370/2764-shu-zu-shi-fou-biao-shi-mou-er-cha-0nbvd/
 */