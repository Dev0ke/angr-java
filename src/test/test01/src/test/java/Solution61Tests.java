import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution61Tests {
    private final Solution61 solution61 = new Solution61();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{4, 5, 1, 2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution61.rotateRight(head, k)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 2});
        int k = 4;
        ListNode expected = ListNode.buildListNode(new int[]{2, 0, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution61.rotateRight(head, k)));
    }
}
