import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution725Tests {
    private final Solution725 solution725 = new Solution725();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3});
        int k = 5;
        ListNode[] expected = new ListNode[]{
                ListNode.buildListNode(new int[]{1}),
                ListNode.buildListNode(new int[]{2}),
                ListNode.buildListNode(new int[]{3}),
                ListNode.buildListNode(new int[]{}),
                ListNode.buildListNode(new int[]{}),
        };
        ListNode[] actual = solution725.splitListToParts(head, k);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 3;
        ListNode[] expected = new ListNode[]{
                ListNode.buildListNode(new int[]{1, 2, 3, 4}),
                ListNode.buildListNode(new int[]{5, 6, 7}),
                ListNode.buildListNode(new int[]{8, 9, 10}),
        };
        ListNode[] actual = solution725.splitListToParts(head, k);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}