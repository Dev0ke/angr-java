import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3217Tests {
    private final Solution3217 solution3217 = new Solution3217();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution3217.modifiedList(nums, head)));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 1, 2, 1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{2, 2, 2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution3217.modifiedList(nums, head)));
    }

    @Test
    public void example3() {
        int[] nums = {5};
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution3217.modifiedList(nums, head)));
    }
}