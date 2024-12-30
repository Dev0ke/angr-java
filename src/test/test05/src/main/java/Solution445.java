import java.util.ArrayDeque;
import java.util.Deque;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
/*
445. 两数相加 II
https://leetcode.cn/problems/add-two-numbers-ii/

给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
提示：
链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0
进阶：如果输入链表不能翻转该如何解决？

相似题目: 2. 两数相加
https://leetcode.cn/problems/add-two-numbers/
206. 反转链表
https://leetcode.cn/problems/reverse-linked-list/
2816. 翻倍以链表形式表示的数字
https://leetcode.cn/problems/double-a-number-represented-as-a-linked-list/
 */