public class SolutionP2674 {
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode slow = list, fast = list;
        while (fast.next != list && fast.next.next != list) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != list) {
            fast = fast.next;
        }
        ListNode head1 = list, tail1 = slow;
        ListNode head2 = slow.next, tail2 = fast;
        tail1.next = head1;
        tail2.next = head2;
        return new ListNode[]{head1, head2};
    }
}
/*
$2674. 拆分循环链表
https://leetcode.cn/problems/split-a-circular-linked-list/description/

现给定一个由正整数组成的 循环链表 list ，你的任务是将其拆分为 2 个 循环链表 ，使得第一个链表包含 list 前半部分 的节点（即 ceil(list.length / 2) 个节点），顺序与 list 中的顺序相同，而第二个链表包含 list 中 剩余 的节点，顺序也与 list 中的顺序相同。
返回一个长度为 2 的数组，其中第一个元素是表示 前半部分 链表的 循环链表 ，第二个元素是表示 后半部分 链表的 循环链表 。
循环链表 是一个普通的链表，唯一的区别是最后一个节点的下一个节点是头节点。
提示：
list 中的节点数范围为 [2, 10^5]
0 <= Node.val <= 10^9
LastNode.next = FirstNode ，其中 LastNode 是链表的最后一个节点，FirstNode 是第一个节点。

快慢指针。
创建快指针和慢指针，初始时都指向头结点，然后每次将快指针向后移动 2 步，将慢指针向后移动 1 步，直到快指针到达循环链表的尾结点或者尾结点的前一个结点（尾结点的后一个结点为头结点），此时慢指针指向的结点就是循环链表的中间结点。
 */