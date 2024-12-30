import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution23Tests {
    private final Solution23 solution23 = new Solution23();

    @Test
    public void example1() {
        ListNode listNode1 = ListNode.buildListNode(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.buildListNode(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.buildListNode(new int[]{2, 6});
        ListNode[] lists = {listNode1, listNode2, listNode3};
        // expected
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }

    @Test
    public void example2() {
        ListNode[] lists = {};
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }

    @Test
    public void example3() {
        ListNode[] lists = {null};
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }
}
