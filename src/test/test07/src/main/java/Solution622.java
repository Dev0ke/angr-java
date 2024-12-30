import java.util.LinkedList;

public class Solution622 {
    static class MyCircularQueue {
        private final int size;
        private final LinkedList<Integer> linkedList;

        public MyCircularQueue(int k) {
            linkedList = new LinkedList<>();
            this.size = k;
        }

        public boolean enQueue(int value) {
            if (linkedList.size() < size) {
                linkedList.addLast(value);
                return true;
            } else {
                return false;
            }
        }

        public boolean deQueue() {
            if (!linkedList.isEmpty()) {
                linkedList.removeFirst();
                return true;
            }
            return false;
        }

        public int Front() {
            if (!linkedList.isEmpty()) {
                return linkedList.peekFirst();
            }
            return -1;
        }

        public int Rear() {
            if (!linkedList.isEmpty()) {
                return linkedList.peekLast();
            }
            return -1;
        }

        public boolean isEmpty() {
            return linkedList.isEmpty();
        }

        public boolean isFull() {
            return linkedList.size() == size;
        }
    }
}
/*
622. 设计循环队列
https://leetcode.cn/problems/design-circular-queue/

设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
你的实现应该支持如下操作：
- MyCircularQueue(k): 构造器，设置队列长度为 k 。
- Front: 从队首获取元素。如果队列为空，返回 -1 。
- Rear: 获取队尾元素。如果队列为空，返回 -1 。
- enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
- deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
- isEmpty(): 检查循环队列是否为空。
- isFull(): 检查循环队列是否已满。
提示：
所有的值都在 0 至 1000 的范围内；
操作数将在 1 至 1000 的范围内；
请不要使用内置的队列库。

感觉同 java.util.LinkedList
 */