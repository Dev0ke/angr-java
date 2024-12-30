import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1670 {
    static class FrontMiddleBackQueue {
        // left 和 right 长度相同，或者 left 比 right 大 1
        private final Deque<Integer> left, right;

        public FrontMiddleBackQueue() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            left.addFirst(val);
            if (left.size() == right.size() + 2) {
                right.addFirst(left.removeLast());
            }
        }

        public void pushMiddle(int val) {
            if (left.size() == right.size() + 1) {
                right.addFirst(left.removeLast());
            }
            left.addLast(val);
        }

        public void pushBack(int val) {
            right.addLast(val);
            if (left.size() == right.size() - 1) {
                left.addLast(right.removeFirst());
            }
        }

        public int popFront() {
            if (left.isEmpty()) return -1;
            int val = left.removeFirst();
            if (left.size() == right.size() - 1) {
                left.addLast(right.removeFirst());
            }
            return val;
        }

        public int popMiddle() {
            if (left.isEmpty()) return -1;
            int val = left.removeLast();
            if (left.size() == right.size() - 1) {
                left.addLast(right.removeFirst());
            }
            return val;
        }

        public int popBack() {
            if (left.isEmpty()) return -1;
            int val;
            if (right.isEmpty()) {
                val = left.removeLast();
            } else {
                val = right.removeLast();
                if (left.size() == right.size() + 2) {
                    right.addFirst(left.removeLast());
                }
            }
            return val;
        }
    }
}
/*
1670. 设计前中后队列
https://leetcode.cn/problems/design-front-middle-back-queue/description/

请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
请你完成 FrontMiddleBack 类：
- FrontMiddleBack() 初始化队列。
- void pushFront(int val) 将 val 添加到队列的 最前面 。
- void pushMiddle(int val) 将 val 添加到队列的 正中间 。
- void pushBack(int val) 将 val 添加到队里的 最后面 。
- int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
- int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
- int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
- 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
- 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
提示：
1 <= val <= 10^9
最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。

双端队列
时间复杂度 O(1)
空间复杂度 O(q)。其中 q 为操作次数
 */