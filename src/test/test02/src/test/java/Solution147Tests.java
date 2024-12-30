import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution147Tests {
    private final Solution147 solution147 = new Solution147();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{4, 2, 1, 3});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution147.insertionSortList(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode expected = ListNode.buildListNode(new int[]{-1, 0, 3, 4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution147.insertionSortList(head)));
    }
}
