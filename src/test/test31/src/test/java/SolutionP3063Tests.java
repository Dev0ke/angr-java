import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3063Tests {
    private final SolutionP3063 solutionP3063 = new SolutionP3063();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 2, 1, 2, 3});
        ListNode expected = ListNode.buildListNode(new int[]{3, 2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP3063.frequenciesOfElements(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 2, 2, 2});
        ListNode expected = ListNode.buildListNode(new int[]{2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP3063.frequenciesOfElements(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{6, 5, 4, 3, 2, 1});
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 1, 1, 1, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP3063.frequenciesOfElements(head)));
    }
}