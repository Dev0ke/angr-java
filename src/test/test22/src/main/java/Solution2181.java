import java.util.ArrayList;
import java.util.List;

public class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        int[] nums = toArray(head);

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            if (num == 0) {
                list.add(sum);
                sum = 0;
            } else {
                sum += num;
            }
        }

        int resLen = list.size() - 1;
        int[] res = new int[resLen];
        for (int i = 1; i <= resLen; i++) {
            res[i - 1] = list.get(i);
        }
        return buildListNode(res);
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

    private ListNode buildListNode(int[] nums) {
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
2181. 合并零之间的节点
https://leetcode.cn/problems/merge-nodes-in-between-zeros/

第 281 场周赛 T2。

给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
返回修改后链表的头节点 head 。
提示：
列表中的节点数目在范围 [3, 2 * 10^5] 内
0 <= Node.val <= 1000
不 存在连续两个 Node.val == 0 的节点
链表的 开端 和 末尾 节点都满足 Node.val == 0

速度为王，转数组降维打击。
 */