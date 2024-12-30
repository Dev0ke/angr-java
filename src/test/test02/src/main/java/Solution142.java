public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 为 null 说明链表无环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 快慢指针相遇时，让慢指针指向头节点，然后快慢指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
/*
142. 环形链表 II
https://leetcode.cn/problems/linked-list-cycle-ii/

给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
比 141 题难度升级。要返回入环的第一个节点
双指针-快慢指针。慢指针每次走一步，快指针每次走两步。快慢指针相遇时，让慢指针指向头节点，
然后快慢指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
提示：
链表中节点的数目范围在范围 [0, 10^4] 内
-10^5 <= Node.val <= 10^5
pos 的值为 -1 或者链表中的一个有效索引
进阶：你是否可以使用 O(1) 空间解决此题？

fast = lenA + lenB + lenC
slow = lenA + lenB
显然 lenC = lenA + lenB
慢指针指向头节点，再相遇
fast = lenA + lenA + lenB = lenA + lenC
slow = lenA
 */