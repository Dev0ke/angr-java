import java.util.Random;

public class Solution382 {
    static class Solution {
        private final ListNode head;
        private final Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            int i = 1;
            int ans = 0;
            for (ListNode node = head; node != null; node = node.next) {
                // 1/i 的概率选中（替换为答案）
                if (random.nextInt(i) == 0) {
                    ans = node.val;
                }
                i++;
            }
            return ans;
        }
    }
}
/*
382. 链表随机节点
https://leetcode.cn/problems/linked-list-random-node/

给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
实现 Solution 类：
- Solution(ListNode head) 使用整数数组初始化对象。
- int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
提示：
链表中的节点数在范围 [1, 10^4] 内
-10^4 <= Node.val <= 10^4
至多调用 getRandom 方法 10^4 次
进阶：
如果链表非常大且长度未知，该怎么处理？
你能否在不使用额外空间的情况下解决此问题？

水塘抽样。
从链表头开始，遍历整个链表，对遍历到的第 i 个节点，随机选择区间 [0,i) 内的一个整数，如果其等于 0，则将答案置为该节点值，否则答案不变。
相似题目: 398. 随机数索引
https://leetcode.cn/problems/random-pick-index/
 */