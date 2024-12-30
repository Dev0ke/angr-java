import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2816 {
    public ListNode doubleIt(ListNode head) {
        return addTwoNumbers(head, head);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
2816. 翻倍以链表形式表示的数字
https://leetcode.cn/problems/double-a-number-represented-as-a-linked-list/

第 358 场周赛 T2。

给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
将链表 翻倍 后，返回头节点 head 。
提示：
链表中节点的数目在范围 [1, 10^4] 内
0 <= Node.val <= 9
生成的输入满足：链表表示一个不含前导零的数字，除了数字 0 本身。

栈 + 竖式加法
相似题目: 445. 两数相加 II
https://leetcode.cn/problems/add-two-numbers-ii/
 */