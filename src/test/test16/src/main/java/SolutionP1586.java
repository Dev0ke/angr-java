import java.util.ArrayList;
import java.util.List;

public class SolutionP1586 {
    static class BSTIterator {
        private final List<Integer> list;
        private int idx;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        public boolean hasNext() {
            return idx < list.size();
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasPrev() {
            return idx > 1;
        }

        public int prev() {
            idx--;
            return list.get(idx - 1);
        }
    }
}
/*
$1586. 二叉搜索树迭代器 II
https://leetcode.cn/problems/binary-search-tree-iterator-ii/

实现二叉搜索树（BST）的中序遍历迭代器 BSTIterator 类：
- BSTIterator(TreeNode root) 初始化 BSTIterator 类的实例。二叉搜索树的根节点 root 作为构造函数的参数传入。内部指针使用一个不存在于树中且小于树中任意值的数值来初始化。
- boolean hasNext() 如果当前指针在中序遍历序列中，存在右侧数值，返回 true ，否则返回 false 。
- int next() 将指针在中序遍历序列中向右移动，然后返回移动后指针所指数值。
- boolean hasPrev() 如果当前指针在中序遍历序列中，存在左侧数值，返回 true ，否则返回 false 。
- int prev() 将指针在中序遍历序列中向左移动，然后返回移动后指针所指数值。
注意，虽然我们使用树中不存在的最小值来初始化内部指针，第一次调用 next() 需要返回二叉搜索树中最小的元素。
你可以假设 next() 和 prev() 的调用总是有效的。即，当 next()/prev() 被调用的时候，在中序遍历序列中一定存在下一个/上一个元素。
进阶：你可以不提前遍历树中的值来解决问题吗？
提示:
树中节点个数的范围是 [1, 10^5] 。
0 <= Node.val <= 10^6
最多调用 10^5 次 hasNext、 next、 hasPrev 和 prev 。

栈
 */