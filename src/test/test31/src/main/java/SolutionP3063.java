import java.util.HashMap;
import java.util.Map;

public class SolutionP3063 {
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> cntMp = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
        while (head != null) {
//            list.add(head.val);
            cntMp.merge(head.val, 1, Integer::sum);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode h0 = dummy;
        for (int num : cntMp.values()) {
            h0.next = new ListNode(num);
            h0 = h0.next;
        }
        return dummy.next;
    }
}
/*
$3063. 链表频率
https://leetcode.cn/problems/linked-list-frequency/description/

给定包含 k 个 不同 元素的链表的 head 节点，创建一个长度为 k 的链表，以 任何顺序 返回链表中所有 不同元素 出现的 频率。返回这个链表的头节点。
提示：
链表中的节点数字范围在 [1, 10^5]之间。
1 <= Node.val <= 10^5

哈希表统计频次。
时间复杂度 O(n)。
 */