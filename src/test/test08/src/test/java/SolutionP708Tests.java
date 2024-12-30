import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP708Tests {
    private final SolutionP708 solutionP708 = new SolutionP708();

    @Test
    public void example1() {
        SolutionP708.Node head = new SolutionP708.Node(3);
        head.next = new SolutionP708.Node(4);
        head.next.next = new SolutionP708.Node(1);
        head.next.next.next = head;
        int insertVal = 2;
        // expected
        SolutionP708.Node expected = new SolutionP708.Node(3);
        expected.next = new SolutionP708.Node(4);
        expected.next.next = new SolutionP708.Node(1);
        expected.next.next.next = new SolutionP708.Node(2);
        expected.next.next.next.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP708.insert(head, insertVal)));
    }

    @Test
    public void example2() {
        SolutionP708.Node head = null;
        int insertVal = 1;
        // expected
        SolutionP708.Node expected = new SolutionP708.Node(1);
        expected.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP708.insert(head, insertVal)));
    }

    @Test
    public void example3() {
        SolutionP708.Node head = new SolutionP708.Node(1);
        head.next = head;
        int insertVal = 0;
        // expected
        SolutionP708.Node expected = new SolutionP708.Node(1);
        expected.next = new SolutionP708.Node(0);
        expected.next.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP708.insert(head, insertVal)));
    }
}
