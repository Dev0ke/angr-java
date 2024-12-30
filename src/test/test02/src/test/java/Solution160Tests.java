import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution160Tests {
    private final Solution160 solution160 = new Solution160();

    @Test
    public void example1() {
        // headC 为相交部分
        ListNode headC = ListNode.buildListNode(new int[]{8, 4, 5});

        ListNode headA = ListNode.buildListNode(new int[]{4, 1});
        headA.next.next = headC;
        ListNode headB = ListNode.buildListNode(new int[]{5, 0, 1});
        headB.next.next.next = headC;
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solution160.getIntersectionNode(headA, headB));
    }

    @Test
    public void example2() {
        // headC 为相交部分
        ListNode headC = ListNode.buildListNode(new int[]{2, 4});

        ListNode headA = ListNode.buildListNode(new int[]{0, 9, 1});
        headA.next.next.next = headC;
        ListNode headB = ListNode.buildListNode(new int[]{3});
        headB.next = headC;
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solution160.getIntersectionNode(headA, headB));
    }

    @Test
    public void example3() {
        // headC 为相交部分
        ListNode headC = null;

        ListNode headA = ListNode.buildListNode(new int[]{2, 6, 4});
        ListNode headB = ListNode.buildListNode(new int[]{1, 5});
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solution160.getIntersectionNode(headA, headB));
    }
}
