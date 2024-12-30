import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                minHeap.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p0 = dummy;
        while (!minHeap.isEmpty()) {
            p0.next = new ListNode(minHeap.poll());
            p0 = p0.next;
        }
        return dummy.next;
    }
}
/*
23. 合并K个升序链表
https://leetcode.cn/problems/merge-k-sorted-lists/

给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

分治法。
优先队列法不易出错。
相似题目: 21. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/
 */