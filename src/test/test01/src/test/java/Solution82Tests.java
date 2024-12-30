import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution82Tests {
    private final Solution82 solution82 = new Solution82();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution82.deleteDuplicates(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 1, 2, 3});
        ListNode expected = ListNode.buildListNode(new int[]{2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution82.deleteDuplicates(head)));
    }
}
