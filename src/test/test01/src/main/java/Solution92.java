public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
/*
92. 反转链表 II
https://leetcode.cn/problems/reverse-linked-list-ii/

给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
提示：
链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

反转链表升级版
一次遍历「穿针引线」反转链表（头插法）
       9,7,[2,5,4,3,]6
step1: 9,7,[5,2,4,3,]6
step2: 9,7,[4,5,2,3,]6
step3: 9,7,[3,4,5,2,]6
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: 206. 反转链表
https://leetcode.cn/problems/reverse-linked-list/
 */
