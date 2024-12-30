public class SolutionP1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head.getNext() != null) {
            printLinkedListInReverse(head.getNext());
        }
        head.printValue();
    }

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }
}
/*
$1265. 逆序打印不可变链表
https://leetcode.cn/problems/print-immutable-linked-list-in-reverse/

给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
- ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
您需要使用以下函数来访问此链表（您 不能 直接访问 ImmutableListNode）：
- ImmutableListNode.printValue()：打印当前节点的值。
- ImmutableListNode.getNext()：返回下一个节点。
输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
提示：
链表的长度在 [1, 1000] 之间。
每个节点的值在 [-1000, 1000] 之间。
进阶：
您是否可以：
使用常数级空间复杂度解决问题？
使用线性级时间复杂度和低于线性级空间复杂度解决问题？

递归
 */