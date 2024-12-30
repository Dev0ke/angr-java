import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution876Tests {
    private final Solution876 solution876 = new Solution876();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = head.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode expected = head.next.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }
}
