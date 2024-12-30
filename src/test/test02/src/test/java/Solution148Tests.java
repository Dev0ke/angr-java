import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution148Tests {
    private final Solution148 solution148 = new Solution148();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{4, 2, 1, 3});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution148.sortList(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode expected = ListNode.buildListNode(new int[]{-1, 0, 3, 4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution148.sortList(head)));
    }

    @Test
    public void example3() {
        ListNode head = null;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution148.sortList(head)));
    }
}
