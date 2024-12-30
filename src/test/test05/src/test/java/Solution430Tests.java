import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution430Tests {
    private final Solution430 solution430 = new Solution430();

    @Test
    public void example1() {
        //  1---2---3---4---5---6--NULL
        //         |
        //         7---8---9---10--NULL
        //             |
        //             11--12--NULL
        Solution430.Node head = new Solution430.Node(1);
        head.next = new Solution430.Node(2);
        head.next.prev = head;
        head.next.next = new Solution430.Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Solution430.Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Solution430.Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Solution430.Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        Solution430.Node node7 = head.next.next.child = new Solution430.Node(7);
        node7.next = new Solution430.Node(8);
        node7.next.prev = node7;
        node7.next.next = new Solution430.Node(9);
        node7.next.next.prev = node7.next;
        node7.next.next.next = new Solution430.Node(10);
        node7.next.next.next.prev = node7.next.next;

        Solution430.Node node11 = node7.next.child = new Solution430.Node(11);
        node11.next = new Solution430.Node(12);
        node11.next.prev = node11;

        // expected
        Solution430.Node expected = new Solution430.Node(1);
        expected.next = new Solution430.Node(2);
        expected.next.prev = expected;
        expected.next.next = new Solution430.Node(3);
        expected.next.next.prev = expected.next;
        expected.next.next.next = new Solution430.Node(7);
        expected.next.next.next.prev = expected.next.next;
        expected.next.next.next.next = new Solution430.Node(8);
        expected.next.next.next.next.prev = expected.next.next.next;
        expected.next.next.next.next.next = new Solution430.Node(11);
        expected.next.next.next.next.next.prev = expected.next.next.next.next;
        expected.next.next.next.next.next.next = new Solution430.Node(12);
        expected.next.next.next.next.next.next.prev = expected.next.next.next.next.next;
        expected.next.next.next.next.next.next.next = new Solution430.Node(9);
        expected.next.next.next.next.next.next.next.prev = expected.next.next.next.next.next.next;
        expected.next.next.next.next.next.next.next.next = new Solution430.Node(10);
        expected.next.next.next.next.next.next.next.next.prev = expected.next.next.next.next.next.next.next;
        expected.next.next.next.next.next.next.next.next.next = new Solution430.Node(4);
        expected.next.next.next.next.next.next.next.next.next.prev = expected.next.next.next.next.next.next.next.next;
        expected.next.next.next.next.next.next.next.next.next.next = new Solution430.Node(5);
        expected.next.next.next.next.next.next.next.next.next.next.prev = expected.next.next.next.next.next.next.next.next.next;
        expected.next.next.next.next.next.next.next.next.next.next.next = new Solution430.Node(6);
        expected.next.next.next.next.next.next.next.next.next.next.next.prev = expected.next.next.next.next.next.next.next.next.next.next;

        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution430.flatten(head)));
    }

    @Test
    public void example2() {
        //  1---2---NULL
        //  |
        //  3---NULL
        Solution430.Node head = new Solution430.Node(1);
        head.next = new Solution430.Node(2);
        head.next.prev = head;
        head.child = new Solution430.Node(3);

        // expected
        Solution430.Node expected = new Solution430.Node(1);
        expected.next = new Solution430.Node(3);
        expected.next.prev = expected;
        expected.next.next = new Solution430.Node(2);
        expected.next.next.prev = expected.next;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution430.flatten(head)));
    }

    @Test
    public void example3() {
        Solution430.Node head = new Solution430.Node();
        // expected
        Solution430.Node expected = new Solution430.Node();
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution430.flatten(head)));
    }
}
