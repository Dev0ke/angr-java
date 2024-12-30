public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = list1;
        for (int i = 0; i < a - 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = p1;
        for (int i = 0; i < b - a + 2; i++) {
            p2 = p2.next;
        }

        p1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = p2;
        return list1;
    }
}
/*
1669. 合并两个链表
https://leetcode.cn/problems/merge-in-between-linked-lists/

给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
下图中蓝色边和节点展示了操作后的结果：
请你返回结果链表的头指针。
提示：
3 <= list1.length <= 10^4
1 <= a <= b < list1.length - 1
1 <= list2.length <= 10^4

模拟
 */