import java.util.ArrayList;
import java.util.List;

public class Solution2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // ListNode => int[]
        int[] nums = toArray(head);

        int len = nums.length;
        // group 长度
        int groupLen = 1;
        // 下标
        int left = 0;
        int right = 0;
        while (left <= right) {
            groupLen++;
            left = right + 1;
            right = Math.min(len - 1, left + groupLen - 1);
            // 反转 每个 偶数 长度组中的节点
            if ((right - left + 1) % 2 == 0) {
                swap(nums, left, right);
            }
        }
        // int[] => ListNode
        return toListNode(nums);
    }

    private void swap(int[] arr, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            int tmp = arr[left + i];
            arr[left + i] = arr[left + len - i - 1];
            arr[left + len - i - 1] = tmp;
        }
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

    private ListNode toListNode(int[] nums) {
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
2074. 反转偶数长度组的节点
https://leetcode.cn/problems/reverse-nodes-in-even-length-groups/

第 267 场周赛 T2。

给你一个链表的头节点 head 。
链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：
节点 1 分配给第一组
节点 2 和 3 分配给第二组
节点 4、5 和 6 分配给第三组，以此类推
注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
提示：
链表中节点数目范围是 [1, 10^5]
0 <= Node.val <= 10^5

模拟。链表，双指针。
 */