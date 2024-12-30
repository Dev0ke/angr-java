import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2674Tests {
    private final SolutionP2674 solutionP2674 = new SolutionP2674();

    @Test
    public void example1() {
        ListNode list = ListNode.buildListNode(new int[]{1, 5, 7});
        list.next.next.next = list;
        ListNode[] expected = {ListNode.buildListNode(new int[]{1, 5}), ListNode.buildListNode(new int[]{7})};
        expected[0].next.next = expected[0];
        expected[1].next = expected[1];
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP2674.splitCircularLinkedList(list)));
    }

    @Test
    public void example2() {
        ListNode list = ListNode.buildListNode(new int[]{2, 6, 1, 5});
        list.next.next.next.next = list;
        ListNode[] expected = {ListNode.buildListNode(new int[]{2, 6}), ListNode.buildListNode(new int[]{1, 5})};
        expected[0].next.next = expected[0];
        expected[1].next.next = expected[1];
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP2674.splitCircularLinkedList(list)));
    }
}