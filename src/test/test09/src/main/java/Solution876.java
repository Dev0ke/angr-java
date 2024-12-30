public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return slow;
    }
}
/*
876. 链表的中间结点
https://leetcode.cn/problems/middle-of-the-linked-list/

第 95 场周赛 T1。

给定一个头结点为 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
提示：
给定链表的结点数介于 1 和 100 之间。

双指针-快慢指针。当快指针以两倍步长走完时，慢指针刚好到达中点。
 */