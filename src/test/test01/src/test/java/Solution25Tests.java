import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution25Tests {
    private final Solution25 solution25 = new Solution25();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{2, 1, 4, 3, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution25.reverseKGroup(head, k)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 3;
        ListNode expected = ListNode.buildListNode(new int[]{3, 2, 1, 4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution25.reverseKGroup(head, k)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 1;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution25.reverseKGroup(head, k)));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        int k = 1;
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution25.reverseKGroup(head, k)));
    }
}
