import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution445Tests {
    private final Solution445 solution445 = new Solution445();

    @Test
    public void example1() {
        ListNode l1 = ListNode.buildListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode expected = ListNode.buildListNode(new int[]{7, 8, 0, 7});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = ListNode.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode expected = ListNode.buildListNode(new int[]{8, 0, 7});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = ListNode.buildListNode(new int[]{0});
        ListNode l2 = ListNode.buildListNode(new int[]{0});
        ListNode expected = ListNode.buildListNode(new int[]{0});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }
}
