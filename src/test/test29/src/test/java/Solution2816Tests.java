import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2816Tests {
    private final Solution2816 solution2816 = new Solution2816();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 8, 9});
        ListNode expected = ListNode.buildListNode(new int[]{3, 7, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2816.doubleIt(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{9, 9, 9});
        ListNode expected = ListNode.buildListNode(new int[]{1, 9, 9, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2816.doubleIt(head)));
    }
}