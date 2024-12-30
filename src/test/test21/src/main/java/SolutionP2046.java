import java.util.ArrayList;
import java.util.List;

public class SolutionP2046 {
    public ListNode sortLinkedList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(null);

        ListNode dummy = new ListNode(-1);
        ListNode h0 = dummy;
        for (int num : list) {
            h0.next = new ListNode(num);
            h0 = h0.next;
        }
        return dummy.next;
    }
}
/*
$2046. 给按照绝对值排序的链表排序
https://leetcode.cn/problems/sort-linked-list-already-sorted-using-absolute-values/description/

给你一个链表的头结点 head ，这个链表是根据结点的绝对值进行升序排序, 返回重新根据节点的值进行升序排序的链表。
提示:
链表节点数的范围是 [1, 10^5].
-5000 <= Node.val <= 5000
head 是根据结点绝对值升序排列好的链表.
进阶:
你可以在O(n)的时间复杂度之内解决这个问题吗?

数组
时间复杂度 O(nlogn)。
 */