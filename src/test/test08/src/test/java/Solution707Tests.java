import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution707Tests {
    @Test
    public void example1() {
        Solution707.MyLinkedList linkedList = new Solution707.MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        // 链表变为1-> 2-> 3
        linkedList.addAtIndex(1, 2);
        // 返回2
        Assertions.assertEquals(2, linkedList.get(1));
        // 现在链表是1-> 3
        linkedList.deleteAtIndex(1);
        // 返回3
        Assertions.assertEquals(3, linkedList.get(1));
    }
}
