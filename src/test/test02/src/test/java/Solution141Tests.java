import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution141Tests {
    private final Solution141 solution141 = new Solution141();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{3, 2, 0, -4});
        head.next.next.next.next = head.next;
        Assertions.assertTrue(solution141.hasCycle(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        head.next.next = head;
        Assertions.assertTrue(solution141.hasCycle(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        Assertions.assertFalse(solution141.hasCycle(head));
    }
}
