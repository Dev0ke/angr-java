import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3263Tests {
    private SolutionP3263.Node buildNode(int[] nums) {
        SolutionP3263.Node dummy = new SolutionP3263.Node();
        SolutionP3263.Node head = dummy;
        for (int num : nums) {
            head.next = new SolutionP3263.Node();
            head.next.val = num;
            head.next.prev = head;
            head = head.next;
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    private final SolutionP3263 solutionP3263 = new SolutionP3263();

    @Test
    public void example1() {
        SolutionP3263.Node head = buildNode(new int[]{1, 2, 3, 4, 3, 2, 1});
        int[] expected = {1, 2, 3, 4, 3, 2, 1};
        Assertions.assertArrayEquals(expected, solutionP3263.toArray(head));
    }

    @Test
    public void example2() {
        SolutionP3263.Node head = buildNode(new int[]{2, 2, 2, 2, 2});
        int[] expected = {2, 2, 2, 2, 2};
        Assertions.assertArrayEquals(expected, solutionP3263.toArray(head));
    }

    @Test
    public void example3() {
        SolutionP3263.Node head = buildNode(new int[]{3, 2, 3, 2, 3, 2});
        int[] expected = {3, 2, 3, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solutionP3263.toArray(head));
    }
}