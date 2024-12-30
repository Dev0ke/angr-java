import java.util.LinkedList;

public class Solution641 {
    static class MyCircularDeque {
        private final int size;
        private final LinkedList<Integer> linkedList;

        public MyCircularDeque(int k) {
            linkedList = new LinkedList<>();
            this.size = k;
        }

        public boolean insertFront(int value) {
            if (linkedList.size() < size) {
                linkedList.addFirst(value);
                return true;
            } else {
                return false;
            }
        }

        public boolean insertLast(int value) {
            if (linkedList.size() < size) {
                linkedList.addLast(value);
                return true;
            } else {
                return false;
            }
        }

        public boolean deleteFront() {
            if (!linkedList.isEmpty()) {
                linkedList.removeFirst();
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (!linkedList.isEmpty()) {
                linkedList.removeLast();
                return true;
            }
            return false;
        }

        public int getFront() {
            if (!linkedList.isEmpty()) {
                return linkedList.peekFirst();
            }
            return -1;
        }

        public int getRear() {
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
641. 设计循环双端队列
https://leetcode.cn/problems/design-circular-deque/

设计实现双端队列。
实现 MyCircularDeque 类:
- MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
- boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
- boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
- boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
- boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
- int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
- int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
- boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
- boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
提示：
1 <= k <= 1000
0 <= value <= 1000
insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次

相似题目: 622. 设计循环队列
https://leetcode.cn/problems/design-circular-queue/
 */