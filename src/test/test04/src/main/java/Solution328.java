import java.util.ArrayList;
import java.util.List;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        int[] arr = toArray(head);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            list.add(arr[i]);
        }
        for (int i = 1; i < arr.length; i += 2) {
            list.add(arr[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head0 = dummy;
        for (int num : list) {
            head0.next = new ListNode(num);
            head0 = head0.next;
        }
        return dummy.next;
    }

    private static int[] toArray(ListNode head) {
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
328. 奇偶链表
https://leetcode.cn/problems/odd-even-linked-list/

给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
提示:
n ==  链表中的节点数
0 <= n <= 10^4
-10^6 <= Node.val <= 10^6

数组模拟。
 */