import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 使用栈还原倒序链表
        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.push(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            stack1.push(l1.val);
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            stack2.push(l2.val);
        }

        // 还原出整数 BigInteger 进行相加
        StringBuilder stringBuilder1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            stringBuilder1.append(stack1.pop());
        }
        BigInteger bigInteger1 = new BigInteger(stringBuilder1.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            stringBuilder2.append(stack2.pop());
        }
        BigInteger bigInteger2 = new BigInteger(stringBuilder2.toString());
        String resStr = bigInteger1.add(bigInteger2).toString();

        // 还原为 ListNode 返回
        ListNode res = new ListNode();
        ListNode dummy = res;
        for (int i = resStr.length() - 1; i >= 0; i--) {
            res.next = new ListNode(resStr.charAt(i) - '0');
            res = res.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
/*
2. 两数相加
https://leetcode.cn/problems/add-two-numbers/

给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

还原出两个整数后，相加得到结果，再构建新的 ListNode 返回。
时间复杂度 O(max(m,n))
官方题解。实际上两整数相加就是从低位相加，直接双指针走一遍也可以。空间复杂度会降低很多。
 */