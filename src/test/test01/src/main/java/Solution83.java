public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            if (left.val != right.val) {
                // nums[left] = nums[right]
                left.next = right;
                // left++
                left = left.next;
            }
            // right++
            right = right.next;
        }
        left.next = null;
        // 注意是返回头节点
        return head;
    }
}
/*
83. 删除排序链表中的重复元素
https://leetcode.cn/problems/remove-duplicates-from-sorted-list/

给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
提示：
链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
输入：head = [1,1,2]
输出：[1,2]

双指针。
相似题目: 27. 移除元素
https://leetcode.cn/problems/remove-element/
 */