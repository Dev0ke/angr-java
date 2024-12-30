import java.util.ArrayList;
import java.util.List;

public class SolutionP369 {
    public ListNode plusOne(ListNode head) {
        int[] arr = toArray(head);
        int[] plusOne = solution66plusOne(arr);
        return buildListNode(plusOne);
    }

    private int[] solution66plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; ) {
            if (digits[i] + 1 < 10) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = (digits[i] + 1) % 10;
                i--;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
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
$369. 给单链表加一
https://leetcode.cn/problems/plus-one-linked-list/

给定一个用链表表示的非负整数， 然后将这个整数 再加上 1 。
这些数字的存储是这样的：最高位有效的数字位于链表的首位 head 。
提示：
链表中的节点数在 [1, 100] 的范围内。
0 <= Node.val <= 9
由链表表示的数字不包含前导零，除了零本身。

模拟。
相似题目: 66. 加一
https://leetcode.cn/problems/plus-one/
 */