import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

public class SolutionP716 {
    static class MaxStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> maxStack;

        public MaxStack() {
            stack = new ArrayDeque<>();
            maxStack = new ArrayDeque<>();
            maxStack.push(Integer.MIN_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            maxStack.push(Math.max(java.util.Optional.ofNullable(maxStack.peek()).orElse(x), x));
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.element();
        }

        public int peekMax() {
            return maxStack.element();
        }

        public int popMax() {
            int max = peekMax();
            Deque<Integer> buffer = new ArrayDeque<>();
            while (top() != max) {
                buffer.push(pop());
            }
            pop();
            while (!buffer.isEmpty()) {
                push(buffer.pop());
            }
            return max;
        }
    }

    static class MaxStack2 {
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList dll;

        public MaxStack2() {
            map = new TreeMap();
            dll = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = dll.add(x);
            if (!map.containsKey(x))
                map.put(x, new ArrayList<Node>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = dll.pop();
            List<Node> L = map.get(val);
            L.remove(L.size() - 1);
            if (L.isEmpty()) map.remove(val);
            return val;
        }

        public int top() {
            return dll.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = peekMax();
            List<Node> L = map.get(max);
            Node node = L.remove(L.size() - 1);
            dll.unlink(node);
            if (L.isEmpty()) map.remove(max);
            return max;
        }

        static class DoubleLinkedList {
            Node head, tail;

            public DoubleLinkedList() {
                head = new Node(0);
                tail = new Node(0);
                head.next = tail;
                tail.prev = head;
            }

            public Node add(int val) {
                Node x = new Node(val);
                x.next = tail;
                x.prev = tail.prev;
                tail.prev = tail.prev.next = x;
                return x;
            }

            public int pop() {
                return unlink(tail.prev).val;
            }

            public int peek() {
                return tail.prev.val;
            }

            public Node unlink(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return node;
            }
        }

        static class Node {
            int val;
            Node prev, next;

            public Node(int v) {
                val = v;
            }
        }
    }
}
/*
$716. 最大栈
https://leetcode.cn/problems/max-stack/

设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。
实现 MaxStack 类：
- MaxStack() 初始化栈对象
- void push(int x) 将元素 x 压入栈中。
- int pop() 移除栈顶元素并返回这个元素。
- int top() 返回栈顶元素，无需移除。
- int peekMax() 检索并返回栈中最大元素，无需移除。
- int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。
提示：
-10^7 <= x <= 10^7
最多调用 10^4 次 push、pop、top、peekMax 和 popMax
调用 pop、top、peekMax 或 popMax 时，栈中 至少存在一个元素
进阶：
试着设计解决方案：调用 top 方法的时间复杂度为 O(1) ，调用其他方法的时间复杂度为 O(logn) 。

双向链表 + 平衡树
难点在 popMax() 实现，官解双栈解法也 TLE
相似题目: 155. 最小栈
https://leetcode.cn/problems/min-stack/
 */