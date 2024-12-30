public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }
        return p1;
    }
}
/*
160. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/

给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。
自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
- intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
- listA - 第一个链表
- listB - 第二个链表
- skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
- skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
提示：
listA 中节点数目为 m
listB 中节点数目为 n
1 <= m, n <= 3 * 10^4
1 <= Node.val <= 10^5
0 <= skipA <= m
0 <= skipB <= n
如果 listA 和 listB 没有交点，intersectVal 为 0
如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]

双指针
如果 pa/pb 不为 null，则 pa/pb 每次往后移一步
如果 pa 为 null 则移到 headB，如果 pb 为 null 则移到 headA
若 pa pb 相交，则 pa 指向节点为相交节点，若 p2 为 null，则两个链表不相交
证明：假设
lenA \
      lenC
lenB /
若相交则 lanA + lenC + lenB
必定等于 lenB + lenC + lenA
时间复杂度 O(m+n)
空间复杂度 O(1)
 */