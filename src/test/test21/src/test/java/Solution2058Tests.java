import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2058Tests {
    private final Solution2058 solution2058 = new Solution2058();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{3, 1});
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution2058.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 3, 1, 2, 5, 1, 2});
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution2058.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 3, 2, 2, 3, 2, 2, 2, 7});
        int[] expected = {3, 3};
        Assertions.assertArrayEquals(expected, solution2058.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{2, 3, 3, 2});
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution2058.nodesBetweenCriticalPoints(head));
    }
}
