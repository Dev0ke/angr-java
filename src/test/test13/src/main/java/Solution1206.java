import java.util.Arrays;
import java.util.Random;

public class Solution1206 {
    static class Skiplist {
        private static final int MAX_LEVEL = 32;
        // 以 p 的概率往上加一层，最后和上限值取最小。
        private static final double P = 0.25;
        private final Random random;
        private final SkiplistNode head;
        private int level;

        public Skiplist() {
            head = new SkiplistNode(-1, MAX_LEVEL);
            level = 0;
            random = new Random();
        }

        public boolean search(int target) {
            SkiplistNode cur = head;
            for (int i = level - 1; i >= 0; i--) {
                // 找到第 i 层小于且最接近 target 的元素
                while (cur.forward[i] != null && cur.forward[i].val < target) {
                    cur = cur.forward[i];
                }
            }
            cur = cur.forward[0];
            return (cur != null) && (cur.val == target);
        }

        public void add(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkiplistNode cur = head;
            for (int i = level - 1; i >= 0; i--) {
                // 找到第 i 层小于且最接近 num 的元素
                while (cur.forward[i] != null && cur.forward[i].val < num) {
                    cur = cur.forward[i];
                }
                update[i] = cur;
            }

            int lv = randomLevel();
            level = Math.max(level, lv);
            SkiplistNode newNode = new SkiplistNode(num, lv);
            for (int i = 0; i < lv; i++) {
                // 对第 i 层状态进行更新，将当前元素的 forward 指向新的节点
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }

        public boolean erase(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
//            Arrays.fill(update, head);
            SkiplistNode cur = head;
            for (int i = level - 1; i >= 0; i--) {
                // 找到第 i 层小于且最接近 num 的元素
                while (cur.forward[i] != null && cur.forward[i].val < num) {
                    cur = cur.forward[i];
                }
                update[i] = cur;
            }
            cur = cur.forward[0];

            if (cur == null || cur.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != cur) {
                    break;
                }
                update[i].forward[i] = cur.forward[i];
            }
            while (level > 1 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }

        private int randomLevel() {
            int lv = 1;
            // nextDouble()方法用于从此随机数生成器的序列中获取下一个伪随机、均匀分布的双精度值，该值介于 0.0 和 1.0 之间。
            while (random.nextDouble() < P && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }

        private static class SkiplistNode {
            int val;
            SkiplistNode[] forward;

            public SkiplistNode(int val, int maxLevel) {
                this.val = val;
                this.forward = new SkiplistNode[maxLevel];
            }
        }
    }
}
/*
1206. 设计跳表
https://leetcode.cn/problems/design-skiplist/

不使用任何库函数，设计一个 跳表 。
跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
了解更多 : https://en.wikipedia.org/wiki/Skip_list
在本题中，你的设计应该要包含这些函数：
- bool search(int target) : 返回target是否存在于跳表中。
- void add(int num): 插入一个元素到跳表。
- bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
提示:
0 <= num, target <= 2 * 10^4
调用search, add,  erase操作次数不大于 5 * 10^4

跳表模板
https://oi-wiki.org/ds/skiplist/
 */