import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2181Tests {
    private final Solution2181 solution2181 = new Solution2181();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        ListNode expected = ListNode.buildListNode(new int[]{4, 11});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2181.mergeNodes(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 0, 3, 0, 2, 2, 0});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2181.mergeNodes(head)));
    }
}
