import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3062Tests {
    private final SolutionP3062 solutionP3062 = new SolutionP3062();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1});
        String expected = "Even";
        Assertions.assertEquals(expected, solutionP3062.gameResult(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{2, 5, 4, 7, 20, 5});
        String expected = "Odd";
        Assertions.assertEquals(expected, solutionP3062.gameResult(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{4, 5, 2, 1});
        String expected = "Tie";
        Assertions.assertEquals(expected, solutionP3062.gameResult(head));
    }
}