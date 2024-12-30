import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2130Tests {
    private final Solution2130 solution2130 = new Solution2130();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 4, 2, 1});
        int expected = 6;
        Assertions.assertEquals(expected, solution2130.pairSum(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{4, 2, 2, 3});
        int expected = 7;
        Assertions.assertEquals(expected, solution2130.pairSum(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 100000});
        int expected = 100001;
        Assertions.assertEquals(expected, solution2130.pairSum(head));
    }
}
