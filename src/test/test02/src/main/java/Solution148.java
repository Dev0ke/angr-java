import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        int[] nums = listNode2Ints(head);
        Arrays.sort(nums);
        return ints2ListNode(nums);
    }

    private int[] listNode2Ints(ListNode head) {
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

    private ListNode ints2ListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
/*
148. 排序链表
https://leetcode.cn/problems/sort-list/

给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
提示：
链表中节点的数目在范围 [0, 5 * 10^4] 内
-10^5 <= Node.val <= 10^5
进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

麻瓜做法: 转成数组 => 排序 => 重建链表
实际考察的是归并排序
 */