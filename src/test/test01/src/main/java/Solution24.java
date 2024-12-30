public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next;
            ListNode q = cur.next.next;
            p.next = q.next;
            q.next = p;
            cur.next = q;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
/*
24. 两两交换链表中的节点
https://leetcode.cn/problems/swap-nodes-in-pairs/

给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100

0 -> 1 -> 2 -> 3
     p    q
 */