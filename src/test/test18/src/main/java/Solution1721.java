import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1721 {
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int sz = list.size();
        Collections.swap(list, k - 1, sz - k);

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
1721. 交换链表中的节点
https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/description/

给你链表的头节点 head 和一个整数 k 。
交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
提示：
链表中节点的数目是 n
1 <= k <= n <= 10^5
0 <= Node.val <= 100

转换为数组后模拟。
时间复杂度 O(n)。
 */