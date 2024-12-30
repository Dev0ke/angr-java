import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1290Tests {
    private final Solution1290 solution1290 = new Solution1290();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 0, 1});
        int expected = 5;
        Assertions.assertEquals(expected, solution1290.getDecimalValue(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0});
        int expected = 0;
        Assertions.assertEquals(expected, solution1290.getDecimalValue(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        int expected = 1;
        Assertions.assertEquals(expected, solution1290.getDecimalValue(head));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        int expected = 18880;
        Assertions.assertEquals(expected, solution1290.getDecimalValue(head));
    }

    @Test
    public void example5() {
        ListNode head = ListNode.buildListNode(new int[]{0, 0});
        int expected = 0;
        Assertions.assertEquals(expected, solution1290.getDecimalValue(head));
    }
}
