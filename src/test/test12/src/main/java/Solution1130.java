import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1130 {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int x : arr) {
            while (!stack.isEmpty() && x >= stack.peek()) {
                mct += stack.pop() * Math.min(stack.peek(), x);
            }
            stack.push(x);
        }
        while (stack.size() > 2) {
            mct += stack.pop() * stack.peek();
        }
        return mct;
    }
}
/*
1130. 叶值的最小代价生成树
https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/

给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
- 每个节点都有 0 个或是 2 个子节点。
- 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
- 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
如果一个节点有 0 个子节点，那么该节点为叶节点。
提示：
2 <= arr.length <= 40
1 <= arr[i] <= 15
答案保证是一个 32 位带符号整数，即小于 2^31 。

单调栈。
问题可以转化为：给定一个数组 arr，不断地合并相邻的数，合并代价为两个数的乘积，合并之后的数为两个数的最大值，直到数组只剩一个数，求最小合并代价和。
时间复杂度 O(n)
空间复杂度 O(n)
 */