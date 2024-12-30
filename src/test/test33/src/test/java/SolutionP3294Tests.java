import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3294Tests {
    SolutionP3294.Node buildNode(int[] nums) {
        SolutionP3294.Node dummy = new SolutionP3294.Node();
        SolutionP3294.Node head = dummy;
        for (int num : nums) {
            head.next = new SolutionP3294.Node();
            head.next.val = num;
            head.next.prev = head;
            head = head.next;
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    private final SolutionP3294 solutionP3294 = new SolutionP3294();

    @Test
    public void example1() {
        SolutionP3294.Node head = buildNode(new int[]{1, 2, 3, 4, 5});
        SolutionP3294.Node node = head.next.next.next.next;
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, solutionP3294.toArray(node));
    }

    @Test
    public void example2() {
        SolutionP3294.Node head = buildNode(new int[]{4, 5, 6, 7, 8});
        SolutionP3294.Node node = head.next.next.next.next;
        int[] expected = {4, 5, 6, 7, 8};
        Assertions.assertArrayEquals(expected, solutionP3294.toArray(node));
    }
}