import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2487Tests {
    private final Solution2487 solution2487 = new Solution2487();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 2, 13, 3, 8});
        ListNode expected = ListNode.buildListNode(new int[]{13, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2487.removeNodes(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 1, 1});
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 1, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2487.removeNodes(head)));
    }
}
