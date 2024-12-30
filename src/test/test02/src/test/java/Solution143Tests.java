import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution143Tests {
    private final Solution143 solution143 = new Solution143();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 4, 2, 3});
        solution143.reorderList(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{1, 5, 2, 4, 3});
        solution143.reorderList(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }
}
