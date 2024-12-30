public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHalf = slow.next;
        if (fast.next != null) {
            secHalf = slow.next.next;
        }
        slow.next = null;
        return assertListNodeEquals(secHalf, solution206reverseList(head));
    }

    private boolean assertListNodeEquals(ListNode expected, ListNode actual) {
        if (expected == null && actual == null) {
            return true;
        } else if (expected == null || actual == null) {
            return false;
        } else if (expected.val != actual.val) {
            return false;
        } else {
            return assertListNodeEquals(expected.next, actual.next);
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
234. 回文链表
https://leetcode.cn/problems/palindrome-linked-list/

给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
提示：
链表中节点数目在范围[1, 10^5] 内
0 <= Node.val <= 9
进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

Step1: 找链表的中间结点。第 876 题 https://leetcode.cn/problems/middle-of-the-linked-list/
Step2: 反转链表。第 206 题 https://leetcode.cn/problems/reverse-linked-list/
Step3: 链表判等。
 */
