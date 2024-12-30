import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1721Tests {
    private final Solution1721 solution1721 = new Solution1721();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1721.swapNodes(head, k)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        int k = 5;
        ListNode expected = ListNode.buildListNode(new int[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1721.swapNodes(head, k)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        int k = 1;
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1721.swapNodes(head, k)));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        int k = 1;
        ListNode expected = ListNode.buildListNode(new int[]{2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1721.swapNodes(head, k)));
    }

    @Test
    public void example5() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1721.swapNodes(head, k)));
    }
}