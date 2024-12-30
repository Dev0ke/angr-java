import java.util.ArrayList;
import java.util.List;

public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int[] arr = toArray(head);
        int len = arr.length;

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += arr[i] << (len - 1 - i);
        }
        return res;
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
1290. 二进制链表转整数
https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/

给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
请你返回该链表所表示数字的 十进制值 。
提示：
链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。

需要得知链表长度，考虑转数组降维打击。
 */