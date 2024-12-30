import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution328Tests {
    private final Solution328 solution328 = new Solution328();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3, 5, 2, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution328.oddEvenList(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        ListNode expected = ListNode.buildListNode(new int[]{2, 3, 6, 7, 1, 5, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution328.oddEvenList(head)));
    }
}
