import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> resList = new ArrayList<>();
        Deque<int[]> stack = new LinkedList<>();

        int idx = 0;
        while (head != null) {
            resList.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < head.val) {
                int[] pop = stack.pop();
                resList.set(pop[1], head.val);
            }
            stack.push(new int[]{head.val, idx++});

            head = head.next;
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
1019. 链表中的下一个更大节点
https://leetcode.cn/problems/next-greater-node-in-linked-list/

给定一个长度为 n 的链表 head
对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
提示：
链表中节点数为 n
1 <= n <= 10^4
1 <= Node.val <= 10^9

单调栈
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 496. 下一个更大元素 I
https://leetcode.cn/problems/next-greater-element-i/
 */