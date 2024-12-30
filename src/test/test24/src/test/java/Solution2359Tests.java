import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2359Tests {
    private final Solution2359 solution2359 = new Solution2359();

    @Test
    public void example1() {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2359.closestMeetingNode(edges, node1, node2));
    }

    @Test
    public void example2() {
        int[] edges = {1, 2, -1};
        int node1 = 0;
        int node2 = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2359.closestMeetingNode(edges, node1, node2));
    }
}
