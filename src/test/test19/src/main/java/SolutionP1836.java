import java.util.HashMap;
import java.util.Map;

public class SolutionP1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        ListNode p1 = head;
        while (p1 != null) {
            cntMap.put(p1.val, cntMap.getOrDefault(p1.val, 0) + 1);
            p1 = p1.next;
        }

        p1 = head;

        // 重建 ListNode
        ListNode dummy = new ListNode(-1);
        ListNode p2 = dummy;
        while (p1 != null) {
            if (cntMap.get(p1.val) == 1) {
                p2.next = new ListNode(p1.val);
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return dummy.next;
    }
}
/*
$1836. 从未排序的链表中移除重复元素
https://leetcode.cn/problems/remove-duplicates-from-an-unsorted-linked-list/

给定一个链表的第一个节点 head ，找到链表中所有出现多于一次的元素，并删除这些元素所在的节点。
返回删除后的链表。
提示：
链表中节点个数的范围是 [1, 10^5]
1 <= Node.val <= 10^5

HashMap 统计频次 + 重建链表
时间复杂度 O(n)
 */