import java.util.ArrayDeque;
import java.util.Deque;

public class Solution155 {
    static class MinStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(java.util.Optional.ofNullable(minStack.peek()).orElse(val), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.element();
        }

        public int getMin() {
            return minStack.element();
        }
    }
}
/*
155. 最小栈
https://leetcode.cn/problems/min-stack/

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
- MinStack() 初始化堆栈对象。
- void push(int val) 将元素val推入堆栈。
- void pop() 删除堆栈顶部的元素。
- int top() 获取堆栈顶部的元素。
- int getMin() 获取堆栈中的最小元素。
提示：
-2^31 <= val <= 2^31 - 1
pop、top 和 getMin 操作总是在 非空栈 上调用
push, pop, top, and getMin最多被调用 3 * 10^4 次

双栈
相似题目: $716. 最大栈
https://leetcode.cn/problems/max-stack/
剑指 Offer 30. 包含min函数的栈
https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
面试题 03.02. 栈的最小值
https://leetcode.cn/problems/min-stack-lcci/
 */
