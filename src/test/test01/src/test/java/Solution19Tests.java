import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution19Tests {
    private final Solution19 solution19 = new Solution19();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution19.removeNthFromEnd(head, n)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        int n = 1;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution19.removeNthFromEnd(head, n)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        int n = 1;
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution19.removeNthFromEnd(head, n)));
    }
}
