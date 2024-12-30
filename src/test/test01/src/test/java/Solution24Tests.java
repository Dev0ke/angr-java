import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution24Tests {
    private final Solution24 solution24 = new Solution24();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{2, 1, 4, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution24.swapPairs(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{});
        ListNode expected = ListNode.buildListNode(new int[]{});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution24.swapPairs(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution24.swapPairs(head)));
    }
}
