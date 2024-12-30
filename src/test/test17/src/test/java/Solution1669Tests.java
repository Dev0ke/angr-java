import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1669Tests {
    private final Solution1669 solution1669 = new Solution1669();

    @Test
    public void example1() {
        ListNode list1 = ListNode.buildListNode(new int[]{0, 1, 2, 3, 4, 5});
        int a = 3;
        int b = 4;
        ListNode list2 = ListNode.buildListNode(new int[]{1000000, 1000001, 1000002});
        ListNode expected = ListNode.buildListNode(new int[]{0, 1, 2, 1000000, 1000001, 1000002, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1669.mergeInBetween(list1, a, b, list2)));
    }

    @Test
    public void example2() {
        ListNode list1 = ListNode.buildListNode(new int[]{0, 1, 2, 3, 4, 5, 6});
        int a = 2;
        int b = 5;
        ListNode list2 = ListNode.buildListNode(new int[]{1000000, 1000001, 1000002, 1000003, 1000004});
        ListNode expected = ListNode.buildListNode(new int[]{0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1669.mergeInBetween(list1, a, b, list2)));
    }
}