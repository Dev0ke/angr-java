import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution203Tests {
    private final Solution203 solution203 = new Solution203();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val = 6;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution203.removeElements(head, val)));
    }

    @Test
    public void example2() {
        ListNode head = null;
        int val = 1;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution203.removeElements(head, val)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{7, 7, 7, 7});
        int val = 7;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution203.removeElements(head, val)));
    }

}
