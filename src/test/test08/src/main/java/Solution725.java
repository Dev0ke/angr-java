import java.util.ArrayList;
import java.util.List;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] arr = toArray(head);
        int n = arr.length;

        int offset = 0;
        int quotient = n / k, remainder = n % k;
        List<ListNode> ans = new ArrayList<>();
        // 前 remainder 个部分的长度各为 quotient+1，其余每个部分的长度各为 quotient。
        for (int i = 0; i < remainder; i++) {
            int st = i * (quotient + 1);
            int end = i * (quotient + 1) + (quotient + 1);
            offset = end;
            extracted(st, end, arr, ans);
        }
        for (int i = 0; i < k - remainder; i++) {
            int st = i * (quotient) + offset;
            int end = i * (quotient) + (quotient) + offset;
            extracted(st, end, arr, ans);
        }
        return ans.toArray(ListNode[]::new);
    }

    private void extracted(int st, int end, int[] arr, List<ListNode> ans) {
        ListNode dummy = new ListNode(-1);
        ListNode head0 = dummy;
        for (int j = st; j < end; j++) {
            head0.next = new ListNode(arr[j]);
            head0 = head0.next;
        }
        ans.add(dummy.next);
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
725. 分隔链表
https://leetcode.cn/problems/split-linked-list-in-parts/description/

给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
返回一个由上述 k 部分组成的数组。
提示：
链表中节点的数目在范围 [0, 1000]
0 <= Node.val <= 1000
1 <= k <= 50

先遍历一次，得到长度，再分割。
时间复杂度 O(n)。
 */