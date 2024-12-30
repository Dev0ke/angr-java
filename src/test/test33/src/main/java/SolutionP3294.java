public class SolutionP3294 {
    public int[] toArray(Node node) {
        Node head = node, tail = node;
        int length = 1;
        while (head.prev != null) {
            head = head.prev;
            length++;
        }
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int[] array = new int[length];
        int index = 0;
        node = head;
        while (node != null) {
            array[index] = node.val;
            index++;
            node = node.next;
        }
        return array;
    }

    // UT
    static class Node {
        public int val;
        public Node prev;
        public Node next;
    }
}
/*
$3294. 将双链表转换为数组 II
https://leetcode.cn/problems/convert-doubly-linked-list-to-array-ii/description/

给定一个 双链表 的 任意 node，其中的节点具有指向下一个节点的指针和上一个节点的指针。
返回一个 按顺序 包含链表中元素的整数数组。
提示：
给定列表中的节点数在范围 [1, 500] 内。
1 <= Node.val <= 1000
所有节点的 Node.val 互不相同。

由于给定的结点可能在双向链表中的任意位置，因此应定位到双向链表的头结点，然后从双向链表的头结点出发遍历链表中的每个结点
https://leetcode.cn/problems/convert-doubly-linked-list-to-array-ii/solutions/2922938/3294-jiang-shuang-lian-biao-zhuan-huan-w-qqhm/
相似题目: $3263. 将双链表转换为数组 I
https://leetcode.cn/problems/convert-doubly-linked-list-to-array-i/description/
 */