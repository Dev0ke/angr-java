import java.util.ArrayDeque;
import java.util.Deque;

public class Solution225 {
    static class MyStack {
        private final Deque<Integer> deque;

        public MyStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.push(x);
        }

        public int pop() {
            return deque.pop();
        }

        public int top() {
            return deque.peek();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
/*
225. 用队列实现栈
https://leetcode.cn/problems/implement-stack-using-queues/

请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
实现 MyStack 类：
- void push(int x) 将元素 x 压入栈顶。
- int pop() 移除并返回栈顶元素。
- int top() 返回栈顶元素。
- boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
注意：
- 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
- 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
提示：
1 <= x <= 9
最多调用100 次 push、pop、top 和 empty
每次调用 pop 和 top 都保证栈不为空

（实际工程中意义不大）
jdk 官方推荐使用 Deque 去实现 Stack
相似题目: 232. 用栈实现队列
https://leetcode.cn/problems/implement-queue-using-stacks/
 */