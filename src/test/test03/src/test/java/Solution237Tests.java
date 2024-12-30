import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution237Tests {
    private final Solution237 solution237 = new Solution237();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 9});
        ListNode expected = ListNode.buildListNode(new int[]{1, 9});
        solution237.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 9});
        ListNode expected = ListNode.buildListNode(new int[]{9});
        solution237.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{4});
        solution237.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1});
        ListNode expected = ListNode.buildListNode(new int[]{1});
        solution237.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example5() {
        ListNode head = ListNode.buildListNode(new int[]{-3, 5, -99});
        ListNode expected = ListNode.buildListNode(new int[]{5, -99});
        solution237.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }
}
