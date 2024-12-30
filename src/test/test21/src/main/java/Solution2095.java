import java.util.ArrayList;
import java.util.List;

public class Solution2095 {
    public ListNode deleteMiddle(ListNode head) {
        int[] nums = toArray(head);
        int n = nums.length;
        int[] newNums = new int[n - 1];
        // p => nums
        int p = 0;
        // q => newNums
        int q = 0;
        while (p < n) {
            if (p != n / 2) {
                newNums[q] = nums[p];
                p++;
                q++;
            } else {
                p++;
            }
        }
        return buildListNode(newNums);
    }

    private ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
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
2095. 删除链表的中间节点
https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/

第 270 场周赛 T2。

给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。

无脑转数组 + 双指针。
 */