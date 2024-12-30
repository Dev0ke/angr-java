public class SolutionP1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode last = head;
        while (cur != null) {
            // 将 mCount 初始化为 m，将 nCount 初始化为 n
            int mCount = m, nCount = n;
            // 遍历 m 个节点
            while (cur != null && mCount != 0) {
                last = cur;
                cur = cur.next;
                mCount--;
            }
            // 遍历 n 个节点
            while (cur != null && nCount != 0) {
                cur = cur.next;
                nCount--;
            }
            // 删除 n 个节点
            last.next = cur;
        }
        return head;
    }
}
/*
$1474. 删除链表 M 个节点之后的 N 个节点
https://leetcode.cn/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/description/

给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
- 开始时以头节点作为当前节点.
- 保留以当前节点开始的前 m 个节点.
- 删除接下来的 n 个节点.
- 重复步骤 2 和 3, 直到到达链表结尾.
在删除了指定结点之后, 返回修改过后的链表的头节点.
提示:
链表中节点数目在范围 [1, 10^4] 内
1 <= Node.val <= 10^6
1 <= m, n <= 1000
进阶: 你能通过 就地 修改链表的方式解决这个问题吗?

遍历链表并原地删除。
时间复杂度 O(n)。
 */