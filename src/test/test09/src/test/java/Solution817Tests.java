import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution817Tests {
    private final Solution817 solution817 = new Solution817();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 2, 3});
        int[] nums = {0, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution817.numComponents(head, nums));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 2, 3, 4});
        int[] nums = {0, 3, 1, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution817.numComponents(head, nums));
    }
}