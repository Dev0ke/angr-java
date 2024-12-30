import java.util.ArrayList;
import java.util.List;

public class Solution2130 {
    public int pairSum(ListNode head) {
        int[] nums = toArray(head);
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i] + nums[n - 1 - i]);
        }
        return max;
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
2130. 链表最大孪生和
https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/

第 69 场双周赛 T2。

在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
- 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
孪生和 定义为一个节点和它孪生节点两者值之和。
给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
提示：
链表的节点数目是 [2, 10^5] 中的 偶数 。
1 <= Node.val <= 10^5

转数组，模拟。
时间复杂度 O(n)
 */