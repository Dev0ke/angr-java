import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1172 {
    static class DinnerPlates {
        private final int capacity;
        private final List<Deque<Integer>> stacks;
        private final PriorityQueue<Integer> minHeap;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            stacks = new ArrayList<>();
            minHeap = new PriorityQueue<>();
        }

        public void push(int val) {
            // 堆中都是越界下标，直接清空
            if (!minHeap.isEmpty() && minHeap.peek() >= stacks.size()) {
                minHeap.clear();
            }
            // 所有栈都是满的
            if (minHeap.isEmpty()) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(val);
                stacks.add(stack);
                // 新的栈没有满，入堆
                if (capacity > 1) {
                    minHeap.add(stacks.size() - 1);
                }
            } else {
                Deque<Integer> stack = stacks.get(minHeap.peek());
                stack.push(val);
                // 栈满了，从堆中去掉
                if (stack.size() == capacity) {
                    minHeap.poll();
                }
            }
        }

        public int pop() {
            // 等价为 popAtStack 最后一个非空栈
            return popAtStack(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            // 如果编号 index 的栈是空的，请返回 -1。
            if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
                return -1;
            }
            Deque<Integer> stack = stacks.get(index);
            // 元素出栈后，栈就不满了，把下标入堆
            if (stack.size() == capacity) {
                minHeap.add(index);
            }
            int val = stack.pop();

            // 去掉末尾的空栈（懒删除，堆中下标在 push 时处理）
            while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
            return val;
        }
    }
}
/*
1172. 餐盘栈
https://leetcode.cn/problems/dinner-plate-stacks/

我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
实现一个叫「餐盘」的类 DinnerPlates：
- DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
- void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
- int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
- int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
提示：
1 <= capacity <= 20000
1 <= val <= 20000
0 <= index <= 100000
最多会对 push，pop，和 popAtStack 进行 200000 次调用。

与其维护第一个未满栈，不如维护所有未满栈
https://leetcode.cn/problems/dinner-plate-stacks/solution/yu-qi-wei-hu-di-yi-ge-wei-man-zhan-bu-ru-sphs/
 */