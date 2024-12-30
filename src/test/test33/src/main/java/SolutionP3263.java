import java.util.ArrayList;
import java.util.List;

public class SolutionP3263 {
    public int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // UT
    static class Node {
        public int val;
        public Node prev;
        public Node next;
    }
}
/*
$3263. 将双链表转换为数组 I
https://leetcode.cn/problems/convert-doubly-linked-list-to-array-i/description/

给定一个 双链表 的 head 节点，其中的节点具有指向下一个节点的指针和上一个节点的指针。
返回一个 按顺序 包含链表中元素的整数数组。
提示：
给定链表中节点的数量在 [1, 50] 范围。
1 <= Node.val <= 50

当成单链表处理。
相似题目: $3294. 将双链表转换为数组 II
https://leetcode.cn/problems/convert-doubly-linked-list-to-array-ii/description/
 */