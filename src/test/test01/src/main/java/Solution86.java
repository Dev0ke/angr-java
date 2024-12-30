import java.util.ArrayList;
import java.util.List;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        // 分左右
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                leftList.add(head.val);
            } else {
                rightList.add(head.val);
            }
            head = head.next;
        }

        // 合并
        leftList.addAll(rightList);

        // List => ListNode
        ListNode dummy = new ListNode(-1);
        ListNode h0 = dummy;
        for (int num : leftList) {
            h0.next = new ListNode(num);
            h0 = h0.next;
        }
        return dummy.next;
    }
}
/*
86. 分隔链表
https://leetcode.cn/problems/partition-list/

给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。
提示：
链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200

借助 List 分左右，再重建 ListNode
 */