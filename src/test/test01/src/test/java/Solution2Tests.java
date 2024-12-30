import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2Tests {
    private final Solution2 solution2 = new Solution2();

    @Test
    public void example1() {
        ListNode l1 = ListNode.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode expected = ListNode.buildListNode(new int[]{7, 0, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers2(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = ListNode.buildListNode(new int[]{0});
        ListNode l2 = ListNode.buildListNode(new int[]{0});
        ListNode expected = ListNode.buildListNode(new int[]{0});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers2(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = ListNode.buildListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.buildListNode(new int[]{9, 9, 9, 9});
        ListNode expected = ListNode.buildListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers2(l1, l2)));
    }
}
