import java.util.ArrayList;
import java.util.List;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int[] nums = toArray(head);
        int len = nums.length;

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        // 避免取余结果为负数
        int idx = ((len - k) % len + len) % len;
        for (int i = 0; i < len; i++) {
            int num = nums[(idx + i) % len];
            res.next = new ListNode(num);
            res = res.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
/*
61. 旋转链表
https://leetcode.cn/problems/rotate-list/

给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
提示：
链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9

环形数组/环形链表。取余模拟即可。
 */