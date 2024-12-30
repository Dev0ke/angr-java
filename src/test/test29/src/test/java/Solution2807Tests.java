import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2807Tests {
    private final Solution2807 solution2807 = new Solution2807();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{18, 6, 10, 3});
        ListNode expected = ListNode.buildListNode(new int[]{18, 6, 6, 2, 10, 1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2807.insertGreatestCommonDivisors(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{7});
        ListNode expected = ListNode.buildListNode(new int[]{7});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2807.insertGreatestCommonDivisors(head)));
    }
}