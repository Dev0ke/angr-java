import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1019Tests {
    private final Solution1019 solution1019 = new Solution1019();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1, 5});
        int[] expected = {5, 5, 0};
        Assertions.assertArrayEquals(expected, solution1019.nextLargerNodes(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{2, 7, 4, 3, 5});
        int[] expected = {7, 0, 5, 5, 0};
        Assertions.assertArrayEquals(expected, solution1019.nextLargerNodes(head));
    }
}