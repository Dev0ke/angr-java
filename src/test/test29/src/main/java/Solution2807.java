import java.util.ArrayList;
import java.util.List;

public class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int x = list.get(i - 1), y = list.get(i);
            ans.add(getGCD(x, y));
            ans.add(y);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head0 = dummy;
        for (int x : ans) {
            head0.next = new ListNode(x);
            head0 = head0.next;
        }
        return dummy.next;
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
2807. 在链表中插入最大公约数
https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/

第 110 场双周赛 T2。

给你一个链表的头 head ，每个结点包含一个整数值。
在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
请你返回插入之后的链表。
两个数的 最大公约数 是可以被两个数字整除的最大正整数。
提示：
链表中结点数目在 [1, 5000] 之间。
1 <= Node.val <= 1000

开挂，转数组
 */