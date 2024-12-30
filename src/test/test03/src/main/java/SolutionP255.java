import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP255 {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length < 2) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int pre : preorder) {
            if (pre < max) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < pre) {
                max = stack.pop();
            }
            stack.push(pre);
        }
        return true;
    }
}
/*
$255. 验证前序遍历序列二叉搜索树
https://leetcode.cn/problems/verify-preorder-sequence-in-binary-search-tree/

给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。
提示:
1 <= preorder.length <= 10^4
1 <= preorder[i] <= 10^4
preorder 中 无重复元素
进阶：您能否使用恒定的空间复杂度来完成此题？

单调栈
 */