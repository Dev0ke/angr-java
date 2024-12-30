import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        int[] arr = toArray(head);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() <= arr[i]) {
                stack.push(arr[i]);
            }
        }
        int sz = stack.size();
        int[] nums = new int[sz];
        for (int i = 0; i < sz; i++) {
            nums[i] = stack.pop();
        }

        ListNode dummy = new ListNode(-1);
        ListNode head1 = dummy;
        for (int num : nums) {
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
2487. 从链表中移除节点
https://leetcode.cn/problems/remove-nodes-from-linked-list/

第 321 场周赛 T3。

给你一个链表的头节点 head 。
对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。
返回修改后链表的头节点 head 。
提示：
给定列表中的节点数目在范围 [1, 10^5] 内
1 <= Node.val <= 10^5

模拟。后往前枚举，丢弃小于当前最大值的数即可。
时间复杂度 O(n)
 */