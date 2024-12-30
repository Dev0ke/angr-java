import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution92Tests {
    private final Solution92 solution92 = new Solution92();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 4;
        ListNode expected = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution92.reverseBetween(head, left, right)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5});
        int left = 1;
        int right = 1;
        ListNode expected = ListNode.buildListNode(new int[]{5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution92.reverseBetween(head, left, right)));
    }
}
