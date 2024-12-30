import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution21Tests {
    private final Solution21 solution21 = new Solution21();

    @Test
    public void example1() {
        ListNode l1 = ListNode.buildListNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.buildListNode(new int[]{1, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 2, 3, 4, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = null;
        ListNode l2 = ListNode.buildListNode(new int[]{0});
        ListNode expected = ListNode.buildListNode(new int[]{0});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }
}
