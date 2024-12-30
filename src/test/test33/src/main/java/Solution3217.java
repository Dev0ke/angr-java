import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int v = head.val;
            if (!set.contains(v)) list.add(v);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode h0 = dummy;
        for (int num : list) {
            h0.next = new ListNode(num);
            h0 = h0.next;
        }
        return dummy.next;
    }
}
/*
3217. 从链表中移除在数组中存在的节点
https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/description/

第 406 场周赛 T2。

给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
nums 中的所有元素都是唯一的。
链表中的节点数在 [1, 10^5] 的范围内。
1 <= Node.val <= 10^5
输入保证链表中至少有一个值没有在 nums 中出现过。

哈希表。
时间复杂度 O(n)。
 */