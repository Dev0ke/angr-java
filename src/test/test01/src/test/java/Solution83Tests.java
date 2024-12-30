import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution83Tests {
    private final Solution83 solution83 = new Solution83();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution83.deleteDuplicates(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 2, 3, 3});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution83.deleteDuplicates(head)));
    }
}
