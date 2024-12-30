import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution86Tests {
    private final Solution86 solution86 = new Solution86();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 2, 4, 3, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution86.partition(head, x)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1});
        int x = 2;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution86.partition(head, x)));
    }
}
