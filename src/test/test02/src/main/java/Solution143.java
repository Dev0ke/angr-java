public class Solution143 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        link(head, solution206reverseList(tmp), dummy);
    }

    private void link(ListNode l1, ListNode l2, ListNode head) {
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = l1.next;

            prev.next = l1;
            l1.next = l2;
            prev = l2;

            l1 = tmp;
            l2 = l2.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
    }

    private ListNode solution206reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
/*
143. 重排链表
https://leetcode.cn/problems/reorder-list/

给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
提示：
链表的长度范围为 [1, 5 * 10^4]
1 <= node.val <= 1000

L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
即：
1,2,3,4,5
=>
1,5,2,4,3
相似题目:
Step1: 找链表的中间结点。876. 链表的中间结点
https://leetcode.cn/problems/middle-of-the-linked-list/
Step2: 反转链表。206. 反转链表
https://leetcode.cn/problems/reverse-linked-list/
Step3: 连接链表。
 */