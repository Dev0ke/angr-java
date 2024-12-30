import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        int[] arr = toArray(head);
        Arrays.sort(arr);
        ListNode dummy = new ListNode(-1);
        ListNode head1 = dummy;
        for (int num : arr) {
            head1.next = new ListNode(num);
            head1 = head1.next;
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
147. 对链表进行插入排序
https://leetcode.cn/problems/insertion-sort-list/

给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
插入排序 算法的步骤:
1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
3.重复直到所有输入数据插入完为止。
下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
对链表进行插入排序。
提示：
列表中的节点数在 [1, 5000]范围内
-5000 <= Node.val <= 5000

转数组不讲武德
 */