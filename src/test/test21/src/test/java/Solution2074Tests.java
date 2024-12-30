import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2074Tests {
    private final Solution2074 solution2074 = new Solution2074();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4});
        ListNode expected = ListNode.buildListNode(new int[]{5, 6, 2, 3, 9, 1, 4, 8, 3, 7});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2074.reverseEvenLengthGroups(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 0, 6});
        ListNode expected = ListNode.buildListNode(new int[]{1, 0, 1, 6});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2074.reverseEvenLengthGroups(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1});
        ListNode expected = ListNode.buildListNode(new int[]{2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2074.reverseEvenLengthGroups(head)));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{8});
        ListNode expected = ListNode.buildListNode(new int[]{8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2074.reverseEvenLengthGroups(head)));
    }
}
