import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution206Tests {
    private final Solution206 solution206 = new Solution206();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{5, 4, 3, 2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution206.reverseList(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution206.reverseList(head)));
    }

    @Test
    public void example3() {
        ListNode head = null;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution206.reverseList(head)));
    }
}
