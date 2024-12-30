import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution142Tests {
    private final Solution142 solution142 = new Solution142();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{3, 2, 0, -4});
        head.next.next.next.next = head.next;
        ListNode expected = head.next;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        head.next.next = head;
        ListNode expected = head;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        ListNode expected = null;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }
}
