import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1474Tests {
    private final SolutionP1474 solutionP1474 = new SolutionP1474();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        int m = 2;
        int n = 3;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 6, 7, 11, 12});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP1474.deleteNodes(head, m, n)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        int m = 1;
        int n = 3;
        ListNode expected = ListNode.buildListNode(new int[]{1, 5, 9});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP1474.deleteNodes(head, m, n)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        int m = 3;
        int n = 1;
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3, 5, 6, 7, 9, 10, 11});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP1474.deleteNodes(head, m, n)));
    }

    @Test
    public void example4() {
        ListNode head = ListNode.buildListNode(new int[]{9, 3, 7, 7, 9, 10, 8, 2});
        int m = 1;
        int n = 2;
        ListNode expected = ListNode.buildListNode(new int[]{9, 7, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionP1474.deleteNodes(head, m, n)));
    }
}